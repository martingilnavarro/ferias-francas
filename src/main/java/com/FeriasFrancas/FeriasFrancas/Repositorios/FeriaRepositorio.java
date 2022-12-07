package com.FeriasFrancas.FeriasFrancas.Repositorios;

import com.FeriasFrancas.FeriasFrancas.Entidades.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriaRepositorio extends CrudRepository<Feria, Long> {

}
