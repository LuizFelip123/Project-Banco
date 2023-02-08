package org.ifba.web.bd.projectbanco.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.ifba.web.bd.projectbanco.model.OAuth2UserGoogle;
import org.ifba.web.bd.projectbanco.model.Usuario;
import org.ifba.web.bd.projectbanco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public boolean isAdministrador() {
        OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Usuario usuario = usuarioRepository.findByEmail(principal.getAttribute("email"));
        
        if (usuario != null) {
            return usuario.isAdmin();
        }
        return false;
    }

    public void addAdminRole(OAuth2AuthenticationToken authentication) {
        Collection<SimpleGrantedAuthority> oldAuthorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
                .getContext().getAuthentication().getAuthorities();
                
        List<SimpleGrantedAuthority> newAuthorities = oldAuthorities.stream().collect(Collectors.toList());
        newAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        SecurityContextHolder.getContext()
                .setAuthentication(new OAuth2AuthenticationToken(
                        (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                        newAuthorities, authentication.getAuthorizedClientRegistrationId()));
    }

    public void setGoogleUserSecurityContext(OAuth2AuthenticationToken authentication) {
        OAuth2User principal = (OAuth2User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        OAuth2UserGoogle oAuth2UserGoogle = new OAuth2UserGoogle(principal);

        SecurityContextHolder.getContext().setAuthentication(
                new OAuth2AuthenticationToken(
                        oAuth2UserGoogle,
                        oAuth2UserGoogle.getAuthorities(), 
                        authentication.getAuthorizedClientRegistrationId()));

    } 

    public void verficarUsuario(){
        OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(usuarioRepository.existsByEmail(principal.getAttribute("email"))==false){
        Usuario usuario = new Usuario();
        usuario.setNome(principal.getName());
        usuario.setAdmin(false);
        usuario.setEmail(principal.getAttribute("email"));
        usuarioRepository.save(usuario); 
       }
}
}
