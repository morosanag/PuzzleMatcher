package com.adobe.mws.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class MwsRestExceptionMapper implements ExceptionMapper<MwsRestException> {

    @Override
    public Response toResponse(MwsRestException ex) {

        MwsExceptionContainer container = new MwsExceptionContainer();
        MwsRestExceptionObject exceptionObject = container.translateException(ex.getMessage());

        // convert exception to response
        return Response.status(exceptionObject.getStatusCode()).entity(exceptionObject).type(MediaType.APPLICATION_JSON)
                .build();
    }

}
