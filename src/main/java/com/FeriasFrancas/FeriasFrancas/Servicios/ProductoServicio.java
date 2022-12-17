package com.FeriasFrancas.FeriasFrancas.Servicios;

import com.FeriasFrancas.FeriasFrancas.Repositorios.ProductoRepositorio;
import com.FeriasFrancas.FeriasFrancas.Entidades.Producto;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public List<Producto> getAll()
{
  List<Producto> lista = new ArrayList<Producto>();
  productoRepositorio.findAll().forEach(registro -> lista.add(registro));;
  return lista;
}

public  Producto getById(Long id){
    return productoRepositorio.findById(id).get();
}
 public void save(Producto feria){
productoRepositorio.save(feria);
 }
 public void delete(Long id){
    productoRepositorio.deleteById(id);
 }

    
}
