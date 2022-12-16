package com.FeriasFrancas.FeriasFrancas.controladores;

import com.FeriasFrancas.FeriasFrancas.Entidades.*;
import com.FeriasFrancas.FeriasFrancas.Servicios.FeriaServicio; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController
@RequestMapping("ferias")
public class FeriaControlador implements WebMvcConfigurer {

    @Autowired
    FeriaServicio feriaServicio;

    @GetMapping()
    private ModelAndView index(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");  
        maw.addObject("titulo", "Listado de Ferias");  
       maw.addObject("vista", "Feria/index");
       maw.addObject("ferias", feriaServicio.getAll());
        return maw;
    }

    @GetMapping("/{id}")
    private ModelAndView one(@PathVariable("id") Long id)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalle de la feria #" + id);
        maw.addObject("vista", "Feria/ver");
        maw.addObject("feria", feriaServicio.getById(id));
        return maw;
    }

    @GetMapping("/crear")
	public ModelAndView crear(Feria feria)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Crear Feria");
        maw.addObject("vista", "Feria/crear");
        maw.addObject("ferias", feriaServicio.getAll());
      //  maw.addObject("localidades", localidadServicio.getAll()); // crear ver como funciona la localidad
        return maw;
	}

  







    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id)
    {
        feriaServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "feria borrado exitosamente");
		return maw;
    }

}
