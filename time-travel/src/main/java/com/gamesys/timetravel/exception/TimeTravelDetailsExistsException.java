package com.gamesys.timetravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TimeTravelDetailsExistsException extends RuntimeException {
    public TimeTravelDetailsExistsException(String message) {
        super(message);
    }

}