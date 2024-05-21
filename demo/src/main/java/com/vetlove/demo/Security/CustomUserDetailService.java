package com.vetlove.demo.Security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Rol;
import com.vetlove.demo.Entidad.UserEntity;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Repositorio.RolRepositorio;
import com.vetlove.demo.Repositorio.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired 
    private RolRepositorio roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found") 
        );

        UserDetails userDetails = new User(userDB.getUsername(), userDB.getPassword(), mapRolesToAuthorities(userDB.getRoles()));
        
        return userDetails;
    }


     private Collection<GrantedAuthority> mapRolesToAuthorities(Set<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity saveCliente(Cliente cliente){
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCedula());
        user.setPassword(passwordEncoder.encode("123"));

        Rol cliRol = roleRepository.findByName("CLIENTE").get();
        Set<Rol> roles = new HashSet<>();
        roles.add(cliRol);
        user.setRoles(roles);
        return user;
    }

    public UserEntity saveVeterinario(Veterinario veterinario){
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getCedula());
        user.setPassword(passwordEncoder.encode(veterinario.getContrasenia()));

        Rol vetRol = roleRepository.findByName("VETERINARIO").get();
        Set<Rol> roles = new HashSet<>();
        roles.add(vetRol);
        user.setRoles(roles);

        return user;
    }

    
}
