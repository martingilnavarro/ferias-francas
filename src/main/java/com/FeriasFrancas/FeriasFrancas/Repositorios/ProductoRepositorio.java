package com.FeriasFrancas.FeriasFrancas.Repositorios;

import com.FeriasFrancas.FeriasFrancas.Entidades.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

}
