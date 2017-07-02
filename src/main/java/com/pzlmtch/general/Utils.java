/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.general;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author gabi
 */
public class Utils {
    
    // REST Utils
    public static Response okResponse() {
        JSONObject responseJSON = new JSONObject();
        try {
            responseJSON.put("response", "OK");
        } catch (JSONException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Status.OK).entity(responseJSON.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    public static void addOkResponseServlet(HttpServletResponse response) {
        
        JSONObject responseJSON = new JSONObject();
        try {
            responseJSON.put("response", "OK");
        } catch (JSONException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(responseJSON.toString());
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // File Utils
    public static String generateFilename(String filename) {
        String newFilename = Constants.IMAGES_PATH + filename;
        newFilename = newFilename.substring(0, newFilename.lastIndexOf(".")) + 
                System.currentTimeMillis() + newFilename.substring(newFilename.lastIndexOf("."));
        return newFilename;
    }
    
}
