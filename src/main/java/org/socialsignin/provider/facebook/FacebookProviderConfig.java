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

	@Value("${facebook.clientId}")
	private String facebookClientId;

	@Value("${facebook.clientSecret}")
	private String facebookClientSecret;
	
	public FacebookProviderConfig() {
		super();
	}
	
	public FacebookProviderConfig(String accessToken) {
		super(new FacebookTemplate(accessToken));
	}
	
	public FacebookProviderConfig(String facebookClientId,
			Facebook authenticatedApi) {
		super(authenticatedApi);
		this.facebookClientId = facebookClientId;
	}
	
	public FacebookProviderConfig(String facebookClientId,String accessToken) {
		super(new FacebookTemplate(accessToken));
		this.facebookClientId = facebookClientId;
	}
	
	public FacebookProviderConfig(String facebookClientId,String facebookClientSecret,ConnectionRepository connectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, connectionFactoryRegistry);
		this.facebookClientSecret = facebookClientSecret;
		this.facebookClientSecret  = facebookClientSecret;
	}

	public FacebookProviderConfig(String facebookClientId,String facebookClientSecret,ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, usersConnectionRepository,
				connectionFactoryRegistry);
		this.facebookClientId = facebookClientSecret;
		this.facebookClientSecret  = facebookClientSecret;
	}
	
	public FacebookProviderConfig(String facebookClientId,String facebookClientSecret,String userId,	UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(userId,usersConnectionRepository,
				connectionFactoryRegistry);
		this.facebookClientId = facebookClientId;
		this.facebookClientSecret  = facebookClientSecret;
	}

	public void setFacebookClientId(String facebookClientId) {
		this.facebookClientId = facebookClientId;
	}

	public void setFacebookClientSecret(String facebookClientSecret) {
		this.facebookClientSecret = facebookClientSecret;
	}
	
	@Override
	protected ConnectionFactory<Facebook> createConnectionFactory() {
		return new FacebookConnectionFactory(facebookClientId,
				facebookClientSecret);
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
