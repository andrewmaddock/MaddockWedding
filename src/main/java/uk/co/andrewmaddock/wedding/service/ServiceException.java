package uk.co.andrewmaddock.wedding.service;

/**
 * Service exception.
 *
 * @author Andrew Maddock
 *         Date: 19/07/13 09:55
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -3916879763155516855L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
