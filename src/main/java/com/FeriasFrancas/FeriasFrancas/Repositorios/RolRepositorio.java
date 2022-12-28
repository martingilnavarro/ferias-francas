package com.FeriasFrancas.FeriasFrancas.Repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FeriasFrancas.FeriasFrancas.Entidades.Rol;

@Repository
public interface RolRepositorio extends CrudRepository<Rol, Long>{
     Optional<Rol> findByNombre(String string);
}
