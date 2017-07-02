/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adobe.mws.cdi;

import com.adobe.mws.ejb.PassConfigClient;
import com.adobe.mws.ejb.PassConfigClientImpl;
import com.adobe.mws.exception.MwsRestException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author gabi
 */
public class MvpdCdiTest {
    
    private static MvpdCdi mvpdCdi;
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    public MvpdCdiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        mvpdCdi = new MvpdCdiImpl();
        PassConfigClient passConfigClient = new PassConfigClientImpl();
        mvpdCdi.setPassConfigClient(passConfigClient);
    }
    
    @Test
    public void testGetAllMvpdsDisneyOk() throws Exception {
        String response = mvpdCdi.getAllMvpds("Disney", "authPerBrowserSession");
        // check if there are any results using request and attribute
        assertTrue(response.contains("Mvpd"));
    }
    
    @Test
    public void testGetAllMvpdsCnnOk() throws Exception {
        String response = mvpdCdi.getAllMvpds("CNN", "authPerAggregator");
        // check if there are any results using request and attribute
        assertTrue(response.contains("Mvpd"));
    }
    
    @Test
    public void testNoResultsForAttribute() throws Exception {
        String response = mvpdCdi.getAllMvpds("CNN", "aaa");
        // check if there are any results using request and attribute
        assertTrue(response.length() == 0);
    }
    
    @Test
    public void testNoResultsForRequestor() throws Exception {
        thrown.expect(MwsRestException.class);
        thrown.expectMessage("MWS003");
        
        String response = mvpdCdi.getAllMvpds("aaaa", "authPerAggregator");
    }
}
