/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adobe.mws.ejb;

import com.adobe.mws.cdi.MvpdCdiImpl;
import com.adobe.mws.exception.MwsRestException;
import com.adobe.mws.general.Constants;
import org.apache.logging.log4j.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import org.json.JSONException;
import org.json.JSONObject;

@Stateless
public class PassConfigClientImpl implements PassConfigClient {

    private final Logger logger = LogManager.getLogger(MvpdCdiImpl.class.getName());

    private final WebTarget webTarget;

    private static final int PASS_CONFIG_CLIENT_READ_TIMEOUT = 30000;
    private static final int PASS_CONFIG_CLIENT_CONNECT_TIMEOUT = 5000;
    private static final String PASS_CONFIG_PATH = "/api/v1/config/";

    public PassConfigClientImpl() {
        this(Constants.PASS_CONFIG_CLIENT_HOST);
    }

    public PassConfigClientImpl(String host) {
        logger.traceEntry();
        logger.log(Level.INFO, "{}", new Object[]{host});

        ClientConfig clientConfig = new ClientConfig()
                .property(ClientProperties.READ_TIMEOUT, PASS_CONFIG_CLIENT_READ_TIMEOUT)
                .property(ClientProperties.CONNECT_TIMEOUT, PASS_CONFIG_CLIENT_CONNECT_TIMEOUT);

        webTarget = ClientBuilder
                .newClient(clientConfig)
                .target(host);

        logger.traceExit();
    }

    @Override
    public JSONObject getPassConfig(String requestor) throws MwsRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}", new Object[]{requestor});

        Response response = webTarget
                .path(PASS_CONFIG_PATH + requestor + ".json")
                .request()
                .get();

        // throw exception in case the response if other 200
        if (response.getStatus() == 400) {
            throw new MwsRestException("MWS003");
        } else if (response.getStatus() != 200) {
            throw new MwsRestException("MWS002");
        }

        JSONObject responseJson = null;

        // convert string to JSONObject
        try {
            responseJson = new JSONObject(response.readEntity(String.class));
        } catch (JSONException ex) {
            logger.catching(ex);
            throw new MwsRestException("MWS001");
        }

        logger.traceExit();
        return responseJson;
    }

}
