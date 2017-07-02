/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adobe.mws.cdi;

import com.adobe.mws.ejb.PassConfigClient;
import com.adobe.mws.exception.MwsRestException;

public interface MvpdCdi {

    public String getAllMvpds(String requestor, String attribute) throws MwsRestException;

    public void setPassConfigClient(PassConfigClient passConfigClient);

}
