package org.socialsignin.provider.facebook;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

@Service
public class FacebookProviderService extends AbstractProviderService<Facebook> {

	@Override
	public Class<Facebook> getApiClass() {
		return Facebook.class;
	}

	@Override
	public Facebook getUnauthenticatedApi() {
		return new FacebookTemplate();
	}

}
