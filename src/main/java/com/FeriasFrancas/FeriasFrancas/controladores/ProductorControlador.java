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
@RequestMapping("productores")
public class ProductorControlador implements WebMvcConfigurer {
    @Autowired
    ProductorServicio productorServicio;

    @GetMapping()
    private ModelAndView index() {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");
        maw.addObject("titulo", "Listado de Productores");
        maw.addObject("vista", "Productor/index");
        maw.addObject("productores", productorServicio.getAll());
        return maw;
    }
    


    @GetMapping("/crear")
    public ModelAndView crear(Productor productor) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("/fragments/base");
        maw.addObject("titulo", "Crear Productor");
        maw.addObject("vista", "Productor/crear");
        maw.addObject("productor", productor);
        return maw;
    }

    @PostMapping("/crear")
    public ModelAndView guardar(@Valid Productor productor, BindingResult br, RedirectAttributes ra) {
        if (br.hasErrors()){
            return this.crear(productor);
        }
        productorServicio.save(productor);

        ModelAndView maw = this.index();
        maw.addObject("exito", "Productor guardado exitosamente");
        return maw;
    }

    @GetMapping("/{id}")
    private ModelAndView one(@PathVariable("id") Long id) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalles del productor #" + id);
        maw.addObject("vista", "Productor/ver");
        maw.addObject("productor", productorServicio.getById(id));
        return maw;
    }
   

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, Productor productor) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Editar productor");
        maw.addObject("vista", "Productor/editar");
        maw.addObject("productor", productorServicio.getById(id));
        return maw;
    }

    @PutMapping("/editar/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @Valid Productor productor, BindingResult br,
            RedirectAttributes ra) {
        if (br.hasErrors()) {
            ModelAndView maw = new ModelAndView();
            maw.setViewName("fragments/base");
            maw.addObject("titulo", "Editar productor");
            maw.addObject("vista", "productor/editar");
            maw.addObject("productor", productor);
            return maw;
        }
        Productor registro = productorServicio.getById(id);
        registro.setNombre(productor.getNombre());
        registro.setTelefono(productor.getTelefono());
        registro.setLocalidad(productor.getLocalidad());
        ModelAndView maw = this.index();
        productorServicio.save(registro);
        maw.addObject("exito", "productor editado exitosamente");
        return maw;
    }

    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id) {
        productorServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "Productor borrado exitosamente");
        return maw;
    }
}
