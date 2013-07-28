/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.provider.facebook;

import org.socialsignin.provider.AbstractProviderConfig;
import org.socialsignin.springsocial.security.FacebookConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

/** 
* @author Michael Lavelle
*/
@Configuration
public class FacebookProviderConfig extends AbstractProviderConfig<Facebook> {
	
	@Autowired(required=false)
	private FacebookConnectInterceptor facebookConnectInterceptor;
	
	public FacebookProviderConfig() {
		super();
	}
	
	public FacebookProviderConfig(String accessToken) {
		super(new FacebookTemplate(accessToken));
	}
	
	public FacebookProviderConfig(
			Facebook authenticatedApi) {
		super(authenticatedApi);
	}

	
	public FacebookProviderConfig(ConnectionRepository connectionRepository) {
		super(connectionRepository);

	}

	public FacebookProviderConfig(ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository) {
		super(connectionRepository, usersConnectionRepository);

	}
	
	public FacebookProviderConfig(String userId,UsersConnectionRepository usersConnectionRepository) {
		super(userId,usersConnectionRepository);
	}

	
	@Override
	protected ConnectInterceptor<Facebook> getConnectInterceptor() {
		return facebookConnectInterceptor;
	}

	@Override
	public Class<Facebook> getApiClass() {
		return Facebook.class;
	}

}
