package com.FeriasFrancas.FeriasFrancas.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FeriasFrancas.FeriasFrancas.Entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    boolean existsByEmail(String email);
}
