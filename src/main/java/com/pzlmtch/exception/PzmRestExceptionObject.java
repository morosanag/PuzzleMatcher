package com.pzlmtch.exception;

import javax.xml.bind.annotation.XmlTransient;

public class PzmRestExceptionObject {

    private String meesageId;
    private Integer statusCode;
    private String title;

    public PzmRestExceptionObject(String meesageId, Integer statusCode, String title) {
        super();
        this.meesageId = meesageId;
        this.statusCode = statusCode;
        this.title = title;
    }

    public String getMeesageId() {
        return meesageId;
    }

    public void setMeesageId(String meesageId) {
        this.meesageId = meesageId;
    }

    @XmlTransient
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
