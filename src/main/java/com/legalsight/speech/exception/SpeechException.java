package com.legalsight.speech.exception;

/**
 * @author kristian.j.s.siador
 */
public class SpeechException extends Exception {
	
    private static final long serialVersionUID = 1L;

    private final String errId;

    private final String errMessage;

    public SpeechException(String errId, String errMessage) {
        super();
        this.errId = errId;
        this.errMessage = errMessage;
    }

    public String getErrId() {
        return errId;
    }

    public String getErrMessage() {
        return errMessage;
    }

}
