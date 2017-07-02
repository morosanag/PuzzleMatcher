package com.pzlmtch.exception;

public class PzmRestException extends Exception {
    
    private static final long serialVersionUID = -1704614259705909983L;
    
    public PzmRestException() {
        
    }
    
    public PzmRestException(String exMessage) {
        super(exMessage);
    }
    
}
