package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.DTOs.VeterinarioDTO;
import com.vetlove.demo.DTOs.VeterinarioMapper;
import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.EstadoVet;
import com.vetlove.demo.Entidad.UserEntity;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IEspecialidadServicio;
import com.vetlove.demo.Interfaz.IEstadoMasServicio;
import com.vetlove.demo.Interfaz.IEstadoVetServicio;
import com.vetlove.demo.Interfaz.IMascotaServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;
import com.vetlove.demo.Repositorio.UsersRepository;
import com.vetlove.demo.Security.CustomUserDetailService;
import com.vetlove.demo.Security.JWTGenerator;



@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class veterinarioController {

    @Autowired
    IClienteServicio clienteServicio;

    @Autowired
    IMascotaServicio mascotaServicio;

    @Autowired
    IVeterinarioServicio veterinarioServicio;

    @Autowired
    IEstadoMasServicio estadoMasServicio;

    @Autowired
    IEspecialidadServicio especialidadServicio;

    @Autowired
    IEstadoVetServicio estadoVetServicio;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;
    
    //Métodos GET
    //localhost:8090/veterinario/all
    @GetMapping("/all")
    public List<Veterinario> getAllVeterinarios(){
        return veterinarioServicio.SearchAll();
    }

    //localhost:8090/veterinario/find?id=1
    @GetMapping("/find")
    public Veterinario getVeterinarioById(@RequestParam Long id){
        return veterinarioServicio.SearchById(id);
    }

    @GetMapping("/findCedula")
    public Veterinario getVeterinarioByCedula(@RequestParam String cedula) {
        return veterinarioServicio.SearchByCedula(cedula);
    }

    @GetMapping("/countVeterinariosActivos")
    public int findCountVeterinariosActivos() {
        return veterinarioServicio.findCountVeterinariosActivos();
    }

    @GetMapping("/countVeterinariosInctivos")
    public int findCountVeterinariosInactivos() {
        return veterinarioServicio.findCountVeterinariosInactivos();
    }
    
    
    //Métodos POST
    // @PostMapping("/add")
    // public void addVeterinario(@RequestBody Veterinario vet) {
    //     EstadoVet estado = estadoVetServicio.SearchByName("Activo");
    //     vet.setEstado(estado);
    //     veterinarioServicio.save(vet);
    // }

    @PostMapping("/add")
    public ResponseEntity addVeterinario(@RequestBody Veterinario vet) {
        EstadoVet estado = estadoVetServicio.SearchByName("Activo");
        vet.setEstado(estado);

        if (userRepository.existsByUsername(vet.getCedula())) {
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.saveVeterinario(vet);
        vet.setUserEntity(userEntity);
        Veterinario vetDB = veterinarioServicio.save(vet);
        VeterinarioDTO newVeterinario = VeterinarioMapper.INSTANCE.convert(vetDB);
        if(newVeterinario == null){
            return new ResponseEntity<VeterinarioDTO>(newVeterinario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<VeterinarioDTO>(newVeterinario, HttpStatus.CREATED);
    }
    


    //Métodos PUT
    @PutMapping("/update")
    public void updateMascota(@RequestBody Veterinario veterinario) {
        veterinarioServicio.updateVeterinario(veterinario);
    }


    //Métodos DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteVeterinarioById(@PathVariable Long id) {
        veterinarioServicio.deleteVeterinario(id);
    }

    @DeleteMapping("/undelete/{id}")
    public void undeleteVeterinarioById(@PathVariable Long id) {
        veterinarioServicio.undeleteVeterinario(id);
    }

    @PostMapping("/login")
    public ResponseEntity loginVeterinario(@RequestBody() Veterinario veterinario) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(veterinario.getCedula(), veterinario.getContrasenia())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<VeterinarioDTO> buscarCliente() {
        
        Veterinario veterinario = veterinarioServicio.SearchByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        if(veterinario == null){
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
    }
    

}