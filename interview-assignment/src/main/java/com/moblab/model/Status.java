package com.moblab.model;

import java.io.Serializable;
import java.util.Objects;

public class Status implements Serializable {

    public static final Status SUCCESS = new Status("000-00-0000", "Success");
    public static final String SERVER_ERROR = "99-9999";

    private static final long serialVersionUID = -9050213832066400434L;

    private String code;
    private String message;

    public Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public Status setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Status setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(code, status.code) &&
                Objects.equals(message, status.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

}
