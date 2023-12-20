package com.example.aula.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.aula.entidades.Usuario;
import com.example.aula.repositories.UsuarioRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override  //acess ciclo de vida do token
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
    	
        Usuario usuario = usuarioRepository.findByEmail(authentication.getName());

        /*Conetudo a ser adicionado ao token*/
        Map<String, Object> map = new HashMap<>();
        map.put("Name",usuario.getUsername());
        map.put("Id", usuario.getId());
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);

        return token;
    }
}
