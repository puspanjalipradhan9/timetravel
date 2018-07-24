package com.gamesys.spacetimetravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class SpaceTimeTravelDetailsExistsException extends RuntimeException {
    public SpaceTimeTravelDetailsExistsException(String message) {
        super(message);
    }

}