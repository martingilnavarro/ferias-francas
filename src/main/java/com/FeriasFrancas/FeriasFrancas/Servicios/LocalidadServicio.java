package com.FeriasFrancas.FeriasFrancas.Servicios;

import com.FeriasFrancas.FeriasFrancas.Entidades.Localidad;
import com.FeriasFrancas.FeriasFrancas.Repositorios.LocalidadRepositorio;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LocalidadServicio {

    @Autowired
    LocalidadRepositorio localidadRepositorio;

    public List<Localidad> getAll()
    {
      List<Localidad> lista = new ArrayList<Localidad>();
      localidadRepositorio.findAll().forEach(registro -> lista.add(registro));;
      return lista;
    }
    
    public  Localidad getById(Long id){
        return localidadRepositorio.findById(id).get();
    }
     public void save(Localidad localidad){
        localidadRepositorio.save(localidad);
     }
     public void delete(Long id){
        localidadRepositorio.deleteById(id);
     }
    
}
