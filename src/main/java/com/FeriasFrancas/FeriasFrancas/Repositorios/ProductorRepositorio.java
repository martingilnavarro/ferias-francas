package com.FeriasFrancas.FeriasFrancas.Repositorios;

import com.FeriasFrancas.FeriasFrancas.Entidades.Productor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductorRepositorio extends CrudRepository<Productor, Long> {
    
}
