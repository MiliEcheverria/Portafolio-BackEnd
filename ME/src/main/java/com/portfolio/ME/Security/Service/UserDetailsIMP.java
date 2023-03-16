<<<<<<< HEAD

package com.portfolio.ME.Security.Service;

import com.portfolio.ME.Security.Entity.Usuario;
import com.portfolio.ME.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsIMP implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
      Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
      return UsuarioPrincipal.build(usuario);
    }
    
}
=======

package com.portfolio.ME.Security.Service;

import com.portfolio.ME.Security.Entity.Usuario;
import com.portfolio.ME.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsIMP implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
      Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
      return UsuarioPrincipal.build(usuario);
    }
    
}
>>>>>>> 51cfe50 (Mi primer commit)
