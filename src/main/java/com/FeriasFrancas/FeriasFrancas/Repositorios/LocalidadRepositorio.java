package com.FeriasFrancas.FeriasFrancas.Repositorios;

import com.FeriasFrancas.FeriasFrancas.Entidades.Localidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalidadRepositorio extends CrudRepository<Localidad, Long> {
    
}
