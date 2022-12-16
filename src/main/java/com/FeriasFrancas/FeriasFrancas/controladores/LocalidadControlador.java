package com.FeriasFrancas.FeriasFrancas.controladores;

import com.FeriasFrancas.FeriasFrancas.Servicios.LocalidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController
@RequestMapping("localidades")
public class LocalidadControlador implements WebMvcConfigurer {

    @Autowired
    LocalidadServicio localidadServicio;

    @GetMapping()
    private ModelAndView index(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");  
        maw.addObject("titulo", "Listado de Ferias");  
       maw.addObject("vista", "Localidad/index");
       maw.addObject("localidades", localidadServicio.getAll());
        return maw;
    }

    
}
