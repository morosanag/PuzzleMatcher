package com.pzlmtch.resource;


import com.pzlmtch.bean.PuzzleDetails;
import com.pzlmtch.ejb.ImageMatcherEjb;
import com.pzlmtch.ejb.PuzzleDetailsEjb;
import com.pzlmtch.exception.PzmRestException;
import com.pzlmtch.general.Utils;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/puzzleDetails")
public class PuzzleMatcherResource {

    private final Logger logger = LogManager.getLogger(PuzzleMatcherResource.class.getName());

    @EJB
    private PuzzleDetailsEjb puzzleDetailsEjb;
    
    //@EJB
    //private ImageMatcherEjb imageMatcherEjb;
    

    @Context
    private HttpServletRequest request;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMpvds() throws PzmRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}, {}", new Object[]{});

        String result = "dsfsdf";
        
        logger.traceExit();
        return Response.status(Status.OK).entity(result).type(MediaType.TEXT_PLAIN).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON) 
    public Response insertPuzzleDetails(PuzzleDetails puzzleDetails) throws PzmRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}", new Object[]{puzzleDetails});

        String sessionId = request.getSession().getId();
        puzzleDetailsEjb.insertPuzzleDetails(sessionId, puzzleDetails);
        
        logger.traceExit();
        return Utils.okResponse();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuzzleResult() throws PzmRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}", new Object[]{});

        String sessionId = request.getSession().getId();
        PuzzleDetails puzzleDetails = puzzleDetailsEjb.getPuzzleDetails(sessionId);
        
        System.out.println(puzzleDetails);
        
        logger.traceExit();
        return Response.status(Status.OK).entity(puzzleDetails).type(MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/puzzleResult")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSimilarityMatrix() throws PzmRestException {
        logger.traceEntry();
        logger.log(Level.INFO, "{}", new Object[]{});

        String sessionId = request.getSession().getId();
        PuzzleDetails puzzleDetails = puzzleDetailsEjb.getPuzzleDetails(sessionId);
        
        System.out.println(puzzleDetails);
        
        String results = puzzleDetailsEjb.getSimilarityMatrix(puzzleDetails);
        
        logger.traceExit();
        return Response.status(Status.OK).entity(results).type(MediaType.TEXT_PLAIN).build();
    }

}
