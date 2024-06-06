package com.springboot.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resource;
    String fieldName;
    String field;
    Long fieldId;

    public ResourceNotFoundException(String resource, String field, String fieldName ) {
        super(String.format("%s not found with %s : %s", resource, field, fieldName));
        this.resource = resource;
        this.fieldName = fieldName;
        this.field = field;
    }

    public ResourceNotFoundException(String resource, String field, Long fieldId) {
        super(String.format("%s not found with %s : %d", resource, field, fieldId));
        this.resource = resource;
        this.fieldId = fieldId;
        this.field = field;
    }


}
