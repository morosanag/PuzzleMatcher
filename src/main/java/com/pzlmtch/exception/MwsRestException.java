package com.adobe.mws.exception;

public class MwsRestException extends Exception {
    
    private static final long serialVersionUID = -1704614259705909983L;
    
    public MwsRestException() {
        
    }
    
    public MwsRestException(String exMessage) {
        super(exMessage);
    }
    
}
