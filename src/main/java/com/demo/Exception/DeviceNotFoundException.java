package com.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DeviceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DeviceNotFoundException(String message) {
        super(message);
    }
}
