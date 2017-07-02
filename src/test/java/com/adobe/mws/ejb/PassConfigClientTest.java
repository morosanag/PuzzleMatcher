/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adobe.mws.ejb;

import com.adobe.mws.exception.MwsRestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author gabi
 */
public class PassConfigClientTest {
    
    private static PassConfigClient passConfigClient; 
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    public PassConfigClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        passConfigClient = new PassConfigClientImpl();
        
    }

    @Test
    public void testServerConnectivity() throws Exception {
        thrown.expect(MwsRestException.class);
        thrown.expectMessage("MWS002");
        
        // we check not a complete path
        PassConfigClient passConfigClient = new PassConfigClientImpl("http://sp.auth.adobe.com/api/v1/");
        String requestor = "Disney";
        passConfigClient.getPassConfig(requestor);
    }
    
    @Test
    public void testBadRequestFromServer() throws Exception {
        thrown.expect(MwsRestException.class);
        thrown.expectMessage("MWS003");
        
        String requestor = "aaa";
        passConfigClient.getPassConfig(requestor);
    }
    
    @Test
    public void testGetPassConfigOk() throws Exception {
        String requestor = "Disney";
        JSONObject response = passConfigClient.getPassConfig(requestor);
        
        JSONArray mvpds = response.getJSONObject("requestor").getJSONObject("mvpds").getJSONArray("mvpd");
        assert (mvpds.length() > 0);
    }
}
