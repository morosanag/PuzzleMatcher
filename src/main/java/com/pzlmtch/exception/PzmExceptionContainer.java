package com.pzlmtch.exception;

import java.util.ArrayList;
import java.util.List;

public class PzmExceptionContainer {

    static List<PzmRestExceptionObject> exceptionsList = new ArrayList<PzmRestExceptionObject>();

    private static final PzmRestExceptionObject unexpectedError = new PzmRestExceptionObject("MWS500", 500, "Unexpected error");

    static {
        exceptionsList.add(new PzmRestExceptionObject("MWS001", 500, "The response from the server could not be parsed"));
        exceptionsList.add(new PzmRestExceptionObject("MWS002", 500, "Error connecting to the server"));
        exceptionsList.add(new PzmRestExceptionObject("MWS003", 500, "Data for requestor could not be found"));
        exceptionsList.add(new PzmRestExceptionObject("MWS004", 400, "Please complete all required query params"));
    }

    public PzmExceptionContainer() {
    }

    public PzmRestExceptionObject translateException(String message) {

        PzmRestExceptionObject returnedException = null;
        for (PzmRestExceptionObject cuteobj : exceptionsList) {
            if (cuteobj.getMeesageId().equals(message)) {
                returnedException = cuteobj;
            }
        }
        
        // return 500 Unexpected error in case of other type of exceptions
        if (returnedException == null) {
            returnedException = unexpectedError;
        }

        return returnedException;
    }

}
