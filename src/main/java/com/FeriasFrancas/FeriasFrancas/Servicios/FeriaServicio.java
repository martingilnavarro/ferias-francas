package com.FeriasFrancas.FeriasFrancas.Servicios;

import java.util.*;
import com.FeriasFrancas.FeriasFrancas.Repositorios.FeriaRepositorio;
import com.FeriasFrancas.FeriasFrancas.Entidades.Feria;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;


@Service
public class FeriaServicio {

    @Autowired    
    FeriaRepositorio feriaRepositorio;

    public List<Feria> getAll()
{
  List<Feria> lista = new ArrayList<Feria>();
  feriaRepositorio.findAll().forEach(registro -> lista.add(registro));;
  return lista;
}

public  Feria getById(Long id){
    return feriaRepositorio.findById(id).get();
}
 public void save(Feria feria){
feriaRepositorio.save(feria);
 }
 public void delete(Long id){
    feriaRepositorio.deleteById(id);
 }

}
