package com.adobe.mws.exception;

import java.util.ArrayList;
import java.util.List;

public class MwsExceptionContainer {

    static List<MwsRestExceptionObject> exceptionsList = new ArrayList<MwsRestExceptionObject>();

    private static final MwsRestExceptionObject unexpectedError = new MwsRestExceptionObject("MWS500", 500, "Unexpected error");

    static {
        exceptionsList.add(new MwsRestExceptionObject("MWS001", 500, "The response from the server could not be parsed"));
        exceptionsList.add(new MwsRestExceptionObject("MWS002", 500, "Error connecting to the server"));
        exceptionsList.add(new MwsRestExceptionObject("MWS003", 500, "Data for requestor could not be found"));
        exceptionsList.add(new MwsRestExceptionObject("MWS004", 400, "Please complete all required query params"));
    }

    public MwsExceptionContainer() {
    }

    public MwsRestExceptionObject translateException(String message) {

        MwsRestExceptionObject returnedException = null;
        for (MwsRestExceptionObject cuteobj : exceptionsList) {
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
