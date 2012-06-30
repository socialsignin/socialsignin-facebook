package org.socialsignin.provider.facebook;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

@Service
public class FacebookProviderService extends AbstractProviderService<Facebook,FacebookProviderConfig> {

	public FacebookProviderService() {
		super();
	}

	public FacebookProviderService(FacebookProviderConfig providerConfig) {
		super(providerConfig);
	}

	@Override
	public Facebook getUnauthenticatedApi() {
		return new FacebookTemplate();
	}

}
