package com.FeriasFrancas.FeriasFrancas.controladores;

import com.FeriasFrancas.FeriasFrancas.Entidades.Productor;
import com.FeriasFrancas.FeriasFrancas.Servicios.ProductorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("productores")
public class ProductorControlador {
    @Autowired
    ProductorServicio productorServicio;

    @GetMapping()
    private ModelAndView  index(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");  
        maw.addObject("titulo", "Listado de Productores");  
       maw.addObject("vista", "Productor/index");
       maw.addObject("Productores", productorServicio.getAll());
        return maw;
    }
    @GetMapping("/crear")
	public ModelAndView crear(Productor productor){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");  
        maw.addObject("titulo", "Crear Productor");  
       maw.addObject("vista", "Productor/crear");
        maw.addObject("productos", productorServicio.getAll());
        return maw;
	}

    @GetMapping("/{id}")
    private ModelAndView one(@PathVariable("id") Long id)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalles del productor #" + id);
        maw.addObject("vista", "Productor/ver");
        maw.addObject("Productor", productorServicio.getById(id));
        return maw;
    }

    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id)
    {
        productorServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "Productor borrado exitosamente");
		return maw;
    }
}
