package javastrava.api.v3.service.exception;

import javastrava.api.v3.model.StravaResponse;

/**
 * <p>
 * Thrown when Strava API returns an HTTP status of 400
 * </p>
 * 
 * @author Dan Shannon
 *
 */
public class InvalidTokenException extends RuntimeException implements StravaAPIException {
	/**
	 * Response from Strava API containing error details
	 */
	private StravaResponse response;

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param status Status string
	 * @param response Response from Strava containing error details
	 * @param cause Underlying cause
	 */
	public InvalidTokenException(final String status, final StravaResponse response, final Throwable cause) {
		super(status + " : " + (response == null ? "" : response.toString()),cause); //$NON-NLS-1$ //$NON-NLS-2$
		this.response = response;
	}

	/**
	 * @see javastrava.api.v3.service.exception.StravaAPIException#getResponse()
	 */
	@Override
	public StravaResponse getResponse() {
		return this.response;
	}

	/**
	 * @see javastrava.api.v3.service.exception.StravaAPIException#setResponse(javastrava.api.v3.model.StravaResponse)
	 */
	@Override
	public void setResponse(final StravaResponse response) {
		this.response = response;
		
	}

}
