package com.gnerga.app.configuration;


import com.gnerga.app.exception.RepositoryForbiddenAccessException;
import com.gnerga.app.exception.RepositoryMovedPermanentlyException;
import com.gnerga.app.exception.RepositoryNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 404 -> new RepositoryNotFoundException();
            case 403 -> new RepositoryForbiddenAccessException();
            case 301 -> new RepositoryMovedPermanentlyException();
            default -> errorDecoder.decode(s, response);
        };
    }
}
