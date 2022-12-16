package com.FeriasFrancas.FeriasFrancas.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeControlador {
    
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");
        maw.addObject("titulo", "Inicio");
        maw.addObject("vista", "inicio/inicio");
        return maw; 
    }
}
