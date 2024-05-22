package com.vetlove.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Administrador;
import com.vetlove.demo.Interfaz.IAdministradorServicio;
import com.vetlove.demo.Repositorio.UsersRepository;
import com.vetlove.demo.Security.JWTGenerator;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "localhost:4200")
public class AdministradorController {
    @Autowired
    private IAdministradorServicio administradorServicio;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/findAdmin")
    public Administrador getAdministrador() {
        return administradorServicio.getAdministrador();
    }
    
    @PutMapping("/update")
    public void updateAdministrador(@RequestBody Administrador admin) {
        administradorServicio.updateAdministrador(admin);
    }


    @PostMapping("/login")
    public ResponseEntity loginAdmin(@RequestBody() Administrador admin) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(admin.getCedula(), admin.getContrasenia())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<Administrador> buscarAdmin() {
        
        Administrador admin = administradorServicio.SearchByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        // VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);
        // System.out.println("Veterinario" + veterinarioDTO);

        if(admin == null){
            return new ResponseEntity<Administrador>(admin, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Administrador>(admin, HttpStatus.OK);
    }
}
