package com.FeriasFrancas.FeriasFrancas.controladores;
// import com.FeriasFrancas.FeriasFrancas.Entidades.*;
 // import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.FeriasFrancas.FeriasFrancas.Servicios.FeriaServicio;

@RestController
//@RequestMapping("feria")
public class FeriaControlador implements WebMvcConfigurer {

    @Autowired
    FeriaServicio feriaServicio;

    @GetMapping
    private ModelAndView index(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Listado de ferias");
        maw.addObject("vista", "ferias/index");
        maw.addObject("ferias", feriaServicio.getAll());
        return maw;
    }

    @GetMapping("/{id}")
    private ModelAndView one(@PathVariable("id") Long id)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalle del jugador #" + id);
        maw.addObject("vista", "jugadores/ver");
        maw.addObject("feria", FeriaServicio.getById(id));
        return maw;
    }


}
