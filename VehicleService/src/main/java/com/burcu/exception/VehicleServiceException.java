package com.burcu.exception;

import lombok.Getter;

@Getter
public class VehicleServiceException extends RuntimeException {

    private final ErrorType errorType;

    public VehicleServiceException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public VehicleServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }


}
