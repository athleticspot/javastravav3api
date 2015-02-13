package stravajava.api.v3.service.impl.retrofit;

import java.util.HashMap;

import stravajava.api.v3.model.StravaGear;
import stravajava.api.v3.service.GearServices;
import stravajava.api.v3.service.exception.NotFoundException;
import stravajava.api.v3.service.exception.UnauthorizedException;

public class GearServicesImpl extends StravaServiceImpl implements GearServices {
	private GearServicesImpl(final String token) {
		super(token);
		this.restService = Retrofit.retrofit(GearServicesRetrofit.class, token, GearServicesRetrofit.LOG_LEVEL);
	}

	/**
	 * <p>
	 * Returns an implementation of {@link GearServices gear services}
	 * </p>
	 * 
	 * <p>
	 * Instances are cached so that if 2 requests are made for the same token, the same instance is returned
	 * </p>
	 * 
	 * @param token
	 *            The Strava access token to be used in requests to the Strava API
	 * @return An implementation of the club services
	 * @throws UnauthorizedException
	 *             If the token used to create the service is invalid
	 */
	public static GearServices implementation(final String token) {
		GearServices restService = restServices.get(token);
		if (restService == null) {
			restService = new GearServicesImpl(token);

			// Store the token for later retrieval so that there's only one service per token
			restServices.put(token, restService);

		}
		return restService;
	}

	private static HashMap<String, GearServices> restServices = new HashMap<String, GearServices>();

	private final GearServicesRetrofit restService;

	@Override
	public StravaGear getGear(final String id) {
		try {
			return this.restService.getGear(id);
		} catch (NotFoundException e) {
			return null;
		} catch (UnauthorizedException e) {
			if (accessTokenIsValid()) {
				StravaGear gear = new StravaGear();
				gear.setId(id);
				return gear;
			} else {
				throw e;
			}
		}
	}

}