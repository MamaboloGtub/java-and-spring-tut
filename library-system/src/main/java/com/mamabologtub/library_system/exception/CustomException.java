package com.mamabologtub.library_system.exception;


/**
 * @Author Tshepo M Mahudu on Aug 8, 2025.
 */

public class CustomException extends RuntimeException {
    /**
     * Generated
     */
    private static final long serialVersionUID = -7460427256795541992L;

    private final int code;

    public CustomException() {
        super();
        this.code = -1;
    }

    public CustomException(int code) {
        super();
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
        this.code = -1;
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomException(String message, Throwable e, int code) {
        super(message, e);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
