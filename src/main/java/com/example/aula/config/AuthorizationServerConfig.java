package com.example.aula.config;

import java.util.Arrays;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	    @Autowired //algortimo de criptografia
	    BCryptPasswordEncoder passwordEncoder;

	    @Autowired //recebe o usuario que tenta fazer login
	    AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtAccessTokenConverter accessTokenConverter;

	    @Autowired
	    private JwtTokenEnhancer tokenEnhancer;
	    
	    @Autowired
	    private JwtTokenStore tokenStore;

	    @Override
	    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	    }

	    @Override //recebe as credenciais da aplicação
	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	        clients.inMemory()
	                .withClient("entra21")
	                .secret(passwordEncoder.encode("entra21-2023"))
	                .scopes("read","write")
	                .authorizedGrantTypes("password") ///tipos de login https://oauth.net/2/
	                .accessTokenValiditySeconds(86400);
	    }

	    @Override //quem autoriza e qual formato do token
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        TokenEnhancerChain chain = new TokenEnhancerChain();
	        chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));
	        endpoints.authenticationManager(authenticationManager)
	                .tokenStore(tokenStore) //token é processado
	                .accessTokenConverter(accessTokenConverter)
	                .tokenEnhancer(chain);
	    }
}
