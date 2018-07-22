package com.gamesys.timetravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TimeTravelDetailsExistsException extends RuntimeException {
    public TimeTravelDetailsExistsException() {
        super();
    }
    public TimeTravelDetailsExistsException(String message, Throwable cause) {
        super(message, cause);
    }
    public TimeTravelDetailsExistsException(String message) {
        super(message);
    }
    public TimeTravelDetailsExistsException(Throwable cause) {
        super(cause);
    }
}