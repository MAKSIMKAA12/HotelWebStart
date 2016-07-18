package by.htp3.hotel.service.exception;

public class ServiceRegistrationException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceRegistrationException(String message) {
		super(message);
	}

	public ServiceRegistrationException(String message, Exception e) {
		super(message, e);
	}

}
