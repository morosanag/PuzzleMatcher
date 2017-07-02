package com.adobe.mws.resource;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.adobe.mws.cdi.MvpdCdi;
import com.adobe.mws.exception.MwsRestException;
import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/")
public class MvpdResource {

    private final Logger logger = LogManager.getLogger(MvpdResource.class.getName());

    @Inject
    private MvpdCdi mvpdCDI;

    public void setMvpdCDI(MvpdCdi mvpdCDI) {
        this.mvpdCDI = mvpdCDI;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMpvds(@QueryParam("requestor") String requestor, @QueryParam("attribute") String attribute) throws MwsRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}, {}", new Object[]{requestor, attribute});

        if (requestor == null || attribute == null) {
            throw new MwsRestException("MWS004");
        }

        String result = mvpdCDI.getAllMvpds(requestor, attribute);

        logger.traceExit();
        return Response.status(Status.OK).entity(result).type(MediaType.TEXT_PLAIN).build();
    }

}
