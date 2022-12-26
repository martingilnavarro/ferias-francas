package com.FeriasFrancas.FeriasFrancas.controladores;

import com.FeriasFrancas.FeriasFrancas.Entidades.*;
import com.FeriasFrancas.FeriasFrancas.Servicios.*;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("productos")
public class ProductoControlador implements WebMvcConfigurer {
    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    EmailServicio emailServicio;

    @GetMapping()
    private ModelAndView index() {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");
        maw.addObject("titulo", "Listado de Productos");
        maw.addObject("vista", "Producto/index");
        maw.addObject("productos", productoServicio.getAll());
        return maw;
    }

   

    @GetMapping("/crear")
    public ModelAndView crear(Producto producto) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");
        maw.addObject("titulo", "Crear Productos");
        maw.addObject("vista", "Producto/crear");
        maw.addObject("producto", producto);
        return maw;
    }

    @PostMapping("/crear")
    public ModelAndView guardar(@Valid Producto producto, BindingResult br, RedirectAttributes ra) {
         if (br.hasErrors()){
            return this.crear(producto);
        }

        productoServicio.save(producto);

        ModelAndView maw = this.index();
        maw.addObject("exito", "Producto guardado exitosamente");
        return maw;
    }
    
    @GetMapping("/{id}")
    private ModelAndView one(@PathVariable("id") Long id) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalle del producto #" + id);
        maw.addObject("vista", "Producto/ver");
        maw.addObject("producto", productoServicio.getById(id));          
        return maw;
    }



   @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, Producto producto) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Editar producto");
        maw.addObject("vista", "Producto/editar");
        maw.addObject("producto", productoServicio.getById(id));
        return maw;
    }

    @PutMapping("/editar/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @Valid Producto producto, BindingResult br,  RedirectAttributes ra) {
        if (br.hasErrors()) {
            ModelAndView maw = new ModelAndView();
            maw.setViewName("fragments/base");
            maw.addObject("titulo", "Editar producto");
            maw.addObject("vista", "Producto/editar");
            maw.addObject("producto", producto);
            return maw;
        }
        Producto registro = productoServicio.getById(id);
        registro.setNombre(producto.getNombre());
        registro.setPrecio(producto.getPrecio());
        registro.setUnidadMedida(producto.getUnidadMedida());
        ModelAndView maw = this.index();
        productoServicio.save(registro);
        maw.addObject("exito", "producto editado exitosamente");
        return maw;
    }



    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id) {
        productoServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "Producto borrado exitosamente");
        return maw;
    } 

}
