package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.UserEntity;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.EntidadRequest.AddClienteRequest;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;
import com.vetlove.demo.Repositorio.UsersRepository;
import com.vetlove.demo.Security.CustomUserDetailService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class ClienteController {
    @Autowired
    private IClienteServicio clienteServicio;

    @Autowired
    private IVeterinarioServicio veterinarioServicio;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager; 

    // Métodos GET

    // http://localhost:8090/cliente/all
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> list = clienteServicio.SearchAll();
        ResponseEntity<List<Cliente>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }

    // http://localhost:8090/cliente/veterinario?id=1
    @GetMapping("/veterinario")
    public ResponseEntity<List<Cliente>> getClienteByVeterinarioId(@RequestParam Long id) {
        List<Cliente> list = clienteServicio.SearchAllByVeterinario(veterinarioServicio.SearchById(id));
        ResponseEntity<List<Cliente>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }

    // http://localhost:8090/cliente/find?id=1
    @GetMapping("find")
    public ResponseEntity<Cliente> getClienteById(@RequestParam Long id) {
        Cliente cliente = clienteServicio.SearchById(id);
        ResponseEntity<Cliente> response = new ResponseEntity<>(cliente, HttpStatus.OK);
        return response;
    }

    // http://localhost:8090/cliente/findCedula?cedula=1125248041
    @GetMapping("/findCedula")
    public ResponseEntity<Cliente> getClienteByCedula(@RequestParam String cedula) {
        Cliente cliente = clienteServicio.SearchByCedula(cedula);
        ResponseEntity<Cliente> response = new ResponseEntity<>(cliente, HttpStatus.OK);
        return response;
    }

    // Métodos POST
    // http://localhost:8090/cliente/add
    // @PostMapping("/add")
    // public ResponseEntity<String> addCliente(@RequestBody AddClienteRequest
    // params) {

    // Cliente client = params.getCliente();
    // Veterinario veterinario =
    // veterinarioServicio.SearchById(Long.parseLong(params.getId()));
    // client.setVeterinario(veterinario);
    // Cliente cliente = clienteServicio.save(client);
    // System.out.println(cliente);

    // return new ResponseEntity<>("SAVED", HttpStatus.NO_CONTENT);
    // }

    @PostMapping("/add")
    public ResponseEntity addCliente(@RequestBody AddClienteRequest params) {
        Cliente cliente = params.getCliente();

        if (userRepository.existsByUsername(cliente.getCedula())) {
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        Veterinario veterinario = veterinarioServicio.SearchById(Long.parseLong(params.getId()));
        if (veterinario == null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.BAD_REQUEST); // Veterinario no encontrado
        }
        cliente.setVeterinario(veterinario);
        
        UserEntity userEntity = customUserDetailService.saveCliente(cliente);
        cliente.setUser(userEntity);
        
        Cliente newCliente = clienteServicio.save(cliente);
        if (newCliente == null) {
            return new ResponseEntity<Cliente>(newCliente, HttpStatus.BAD_REQUEST); // Fallo al guardar el cliente
        }
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
    }

    // Métodos PUT
    // http://localhost:8090/cliente/update
    @PutMapping("/update")
    public ResponseEntity<String> updataeCliente(@RequestBody AddClienteRequest params) {
        Veterinario veterinario = clienteServicio.SearchById(Long.parseLong(params.getId())).getVeterinario();
        Cliente cliente = params.getCliente();
        cliente.setVeterinario(veterinario);
        Cliente client = clienteServicio.save(cliente);
        System.out.println(client);

        return new ResponseEntity<>("SAVED", HttpStatus.NO_CONTENT);
    }

    // Métodos DELETE
    // http://localhost:8090/cliente/delete?id=1
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCliente(@RequestParam Long id) {
        clienteServicio.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.NO_CONTENT);
    }


    // http://localhost:8090/cliente/login?12345678
    @PostMapping("/login")
    public ResponseEntity loginCliente(@RequestBody Cliente cliente) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(cliente.getCedula(), "123")
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<String>("Usuario ingresado con éxito", HttpStatus.OK);
    }
    

}