package com.digitalsouag.redditapi.exception;

public class SpringRedditException extends RuntimeException {
    public SpringRedditException(String message, Exception cause) {
        super(message, cause);
    }
    public SpringRedditException(String msg) {
        super(msg);
    }
}
