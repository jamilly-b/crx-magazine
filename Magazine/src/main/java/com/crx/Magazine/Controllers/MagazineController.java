package com.crx.Magazine.Controllers;

import com.crx.Magazine.Models.Entities.Artigo;
import com.crx.Magazine.Models.Repository.CrxMagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MagazineController {

    @Autowired
    CrxMagazineRepository magazineRepository;

    @RequestMapping(value = "/materias", method = RequestMethod.GET)
    public ModelAndView getArtigos(){
        ModelAndView mv = new ModelAndView("artigos");
        List<Artigo> artigos = magazineRepository.findAll();
        mv.addObject("artigos", artigos);
        return mv;
    }

    @RequestMapping(value = "/materia/{id}", method = RequestMethod.GET)
    public ModelAndView getArtigoDetail(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("materia");
        Optional<Artigo> optionalMateria = magazineRepository.findById(id);
        if (optionalMateria.isPresent()) {
            Artigo materia = optionalMateria.get();
            mv.addObject("materia", materia);
        } else {
            mv.addObject("error", "Matéria não encontrada");
        }
        return mv;
    }


}
