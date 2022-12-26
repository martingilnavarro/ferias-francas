package com.FeriasFrancas.FeriasFrancas.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.FeriasFrancas.FeriasFrancas.Entidades.Rol;
import com.FeriasFrancas.FeriasFrancas.Repositorios.RolRepositorio;

@Service
public class RolServicio {

      @Autowired
    RolRepositorio rolRepositorio;

    public List<Rol> getAll()
    {
        List<Rol> lista = new ArrayList<Rol>();
        rolRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    public Rol getById(Long id)
    {
        return rolRepositorio.findById(id).get();
    }

    public void save(Rol rol)
    {
        rolRepositorio.save(rol);
    }

    public void delete(Long id)
    {
        rolRepositorio.deleteById(id);
    }
    
}
