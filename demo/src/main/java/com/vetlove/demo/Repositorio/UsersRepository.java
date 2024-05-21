package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetlove.demo.Entidad.UserEntity;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username); 
}
