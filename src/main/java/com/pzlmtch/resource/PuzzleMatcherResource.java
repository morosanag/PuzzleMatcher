package com.pzlmtch.resource;


import com.pzlmtch.ejb.PuzzleDetailsEjb;
import com.pzlmtch.exception.PzmRestException;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/")
public class PuzzleMatcherResource {

    private final Logger logger = LogManager.getLogger(PuzzleMatcherResource.class.getName());

    @EJB
    private PuzzleDetailsEjb puzzleDetailsEjb;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMpvds() throws PzmRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}, {}", new Object[]{});

        String result = puzzleDetailsEjb.test();
        
        logger.traceExit();
        return Response.status(Status.OK).entity(result).type(MediaType.TEXT_PLAIN).build();
    }

}
