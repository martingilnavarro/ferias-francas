package com.FeriasFrancas.FeriasFrancas.Servicios;

import com.FeriasFrancas.FeriasFrancas.Repositorios.ProductorRepositorio;
import com.FeriasFrancas.FeriasFrancas.Entidades.Productor;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductorServicio {

    @Autowired
    ProductorRepositorio productorRepositorio;

    public List<Productor> getAll()
    {
      List<Productor> lista = new ArrayList<Productor>();
      productorRepositorio.findAll().forEach(registro -> lista.add(registro));;
      return lista;
    }
    
    public  Productor getById(Long id){
        return productorRepositorio.findById(id).get();
    }
     public void save(Productor productor){
        productorRepositorio.save(productor);
     }
     public void delete(Long id){
        productorRepositorio.deleteById(id);
     }
    
}
