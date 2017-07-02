package com.adobe.mws.cdi;

import com.adobe.mws.ejb.PassConfigClient;
import com.adobe.mws.exception.MwsRestException;

import javax.ejb.EJB;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MvpdCdiImpl implements MvpdCdi {

    private final Logger logger = LogManager.getLogger(MvpdCdiImpl.class.getName());

    @EJB
    private PassConfigClient passConfigClient;

    @Override
    public String getAllMvpds(String requestor, String attribute) throws MwsRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}, {}", new Object[]{requestor, attribute});

        JSONObject passConfigResponse = passConfigClient.getPassConfig(requestor);
        JSONArray mvpds = null;

        // extract json array containing information about mvpds
        try {
            mvpds = passConfigResponse.getJSONObject("requestor").getJSONObject("mvpds").getJSONArray("mvpd");
        } catch (JSONException ex) {
            logger.catching(ex);
            throw new MwsRestException("MWS001");
        }

        StringBuilder str = new StringBuilder();

        //format response with only the jsons containing the attribute
        for (int i = 0; i < mvpds.length(); i++) {
            try {
                JSONObject mvpd = mvpds.getJSONObject(i);
                if (mvpd.has(attribute)) {
                    String mvpdName = mvpd.getJSONObject("id").getString("value");
                    Object attributeValue = mvpd.get(attribute);
                    str.append("Mvpd : ").append(mvpdName).append(" , ").append(attribute).append("=").append(attributeValue).append("\n");
                }
            } catch (JSONException ex) {
                logger.catching(ex);
                throw new MwsRestException("MWS001");
            }
        }

        logger.traceExit();
        return str.toString();
    }

    @Override
    public void setPassConfigClient(PassConfigClient passConfigClient) {
        this.passConfigClient = passConfigClient;
    }
}
