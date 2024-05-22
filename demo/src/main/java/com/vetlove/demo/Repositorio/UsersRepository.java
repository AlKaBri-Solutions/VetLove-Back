package com.vetlove.demo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vetlove.demo.Entidad.UserEntity;


public interface UsersRepository extends JpaRepository<UserEntity, Long>{
    @Modifying
    @Query(value = "DELETE FROM USER_ROLES WHERE USER_ID = :id", nativeQuery = true)
    void deleteUserRoleById (Long id);

    void deleteByUsername(String username);
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username); 
}
