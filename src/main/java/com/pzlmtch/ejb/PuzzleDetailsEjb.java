/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adobe.mws.ejb;

import com.adobe.mws.exception.MwsRestException;
import org.json.JSONObject;

public interface PassConfigClient {

    public JSONObject getPassConfig(String requestor) throws MwsRestException;

}
