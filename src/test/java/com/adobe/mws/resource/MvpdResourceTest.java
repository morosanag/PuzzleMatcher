/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adobe.mws.resource;

import com.adobe.mws.cdi.MvpdCdi;
import com.adobe.mws.cdi.MvpdCdiImpl;
import com.adobe.mws.ejb.PassConfigClient;
import com.adobe.mws.ejb.PassConfigClientImpl;
import com.adobe.mws.exception.MwsRestException;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author gabi
 */
public class MvpdResourceTest {
    
    private MvpdResource mvpdResource;
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    public MvpdResourceTest() {
        mvpdResource = new MvpdResource();
        MvpdCdi mvpdCdi = new MvpdCdiImpl();
        PassConfigClient passConfigClient = new PassConfigClientImpl();
        mvpdCdi.setPassConfigClient(passConfigClient);
        mvpdResource.setMvpdCDI(mvpdCdi);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetMpvdsOk() throws Exception {
        Response response = mvpdResource.getMpvds("Disney", "authPerAggregator");
        
        assertTrue(response.getStatus() == 200);
        assertTrue(response.getEntity().toString().contains("Mvpd"));
    }
    
    @Test
    public void testCheckNullParameters() throws Exception {
        thrown.expect(MwsRestException.class);
        thrown.expectMessage("MWS004");
        
        Response response = mvpdResource.getMpvds(null, null);
    }
}
