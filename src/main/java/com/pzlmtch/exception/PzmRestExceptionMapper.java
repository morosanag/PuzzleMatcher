package com.pzlmtch.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class PzmRestExceptionMapper implements ExceptionMapper<PzmRestException> {

    @Override
    public Response toResponse(PzmRestException ex) {

        PzmExceptionContainer container = new PzmExceptionContainer();
        PzmRestExceptionObject exceptionObject = container.translateException(ex.getMessage());

        // convert exception to response
        return Response.status(exceptionObject.getStatusCode()).entity(exceptionObject).type(MediaType.APPLICATION_JSON)
                .build();
    }

}
