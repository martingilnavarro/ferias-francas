package com.FeriasFrancas.FeriasFrancas.controladores;

import com.FeriasFrancas.FeriasFrancas.Entidades.*;
import com.FeriasFrancas.FeriasFrancas.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("productos")
public class ProductoControlador implements WebMvcConfigurer {
    @Autowired
    ProductoServicio productoServicio;
   
    @GetMapping()
    private ModelAndView  index(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");  
        maw.addObject("titulo", "Listado de Productos");  
       maw.addObject("vista", "Producto/index");
       maw.addObject("Productos", productoServicio.getAll());
        return maw;
    }
 

    @GetMapping("/crear")
	public ModelAndView crear(Producto producto){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");  
        maw.addObject("titulo", "Crear Productos");  
       maw.addObject("vista", "Producto/crear");
        maw.addObject("productos", productoServicio.getAll());
        return maw;
	}

    @GetMapping("/{id}")
    private ModelAndView one(@PathVariable("id") Long id)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalle del producto #" + id);
        maw.addObject("vista", "Producto/ver");
        maw.addObject("Producto", productoServicio.getById(id));
        return maw;
    }

    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id)
    {
        productoServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "Producto borrado exitosamente");
		return maw;
    }

    
}
