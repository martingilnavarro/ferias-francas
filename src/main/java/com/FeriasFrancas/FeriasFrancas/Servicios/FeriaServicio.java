package com.FeriasFrancas.FeriasFrancas.Servicios;

import com.FeriasFrancas.FeriasFrancas.Repositorios.*;
import com.FeriasFrancas.FeriasFrancas.Entidades.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class FeriaServicio {

    @Autowired
    static
    FeriaRepositorio feriaRepositorio;

    public List<Feria> getAll()
{
  List<Feria> lista = new ArrayList<Feria>();
  feriaRepositorio.findAll().forEach(registro -> lista.add(registro));;
  return lista;
}

public static Feria getById(Long id){
    return feriaRepositorio.findById(id).get();
}
 public void save(Feria feria){
feriaRepositorio.save(feria);
 }
 public void delete(Long id){
    feriaRepositorio.deleteById(id);
 }

}
