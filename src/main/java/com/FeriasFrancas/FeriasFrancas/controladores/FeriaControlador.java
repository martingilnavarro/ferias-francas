package com.FeriasFrancas.FeriasFrancas.controladores;

import com.FeriasFrancas.FeriasFrancas.Entidades.*;
import com.FeriasFrancas.FeriasFrancas.Servicios.FeriaServicio;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
   

    @GetMapping("/crear")
	public ModelAndView crear(Feria feria)
    {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Crear Feria");
        maw.addObject("vista", "Feria/crear");  
        maw.addObject("feria", feria);        
        return maw;
	}
     
	@PostMapping("/crear")
	public ModelAndView guardar(@Valid Feria feria, BindingResult br, RedirectAttributes ra)
    {
		if ( br.hasErrors() ) {
			return this.crear(feria);
		}

        feria.getHoraApertura().toString();
        feria.getHoraCierre().toString();
		feriaServicio.save(feria);

            
        
        ModelAndView maw = this.index();
        
        maw.addObject("exito", "Feria guardada exitosamente");
		return maw;
	}

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id, Feria feria) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Editar feria");
        maw.addObject("vista", "Feria/editar");
        maw.addObject("feria", feriaServicio.getById(id));
        return maw;
    }

    @PutMapping("/editar/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @Valid Feria feria, BindingResult br,  RedirectAttributes ra) {
        if (br.hasErrors()) {
            ModelAndView maw = new ModelAndView();
            maw.setViewName("fragments/base");
            maw.addObject("titulo", "Editar feria");
            maw.addObject("vista", "Feria/editar");
            maw.addObject("feria", feria);
            return maw;
        }
        Feria registro = feriaServicio.getById(id);
        registro.setNombre(feria.getNombre());
        registro.setDias(feria.getDias());
        registro.setHoraApertura(feria.getHoraApertura());
        registro.setHoraCierre(feria.getHoraCierre());
        registro.setDireccion(feria.getDireccion());
        ModelAndView maw = this.index();
        feriaServicio.save(registro);
        maw.addObject("exito", "Feria editada exitosamente");
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

    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id)
    {
        feriaServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "feria borrado exitosamente");
		return maw;
    }
}
