package com.crx.Magazine.Controllers;

import com.crx.Magazine.Models.Entities.Artigo;
import com.crx.Magazine.Models.Entities.User;
import com.crx.Magazine.Models.Repository.CrxMagazineRepository;
import com.crx.Magazine.Models.Repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/autor/{nome}/{id}", method = RequestMethod.GET)
    public ModelAndView getAutorDetails(@PathVariable("nome") String nome, @PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("autor");
        Optional<User> autor = userRepository.findById(id);

        if (autor.isPresent() && autor.get().getNome().equals(nome)) {
            List<Artigo> artigos = magazineRepository.findByEscritorId(id);
            mv.addObject("autor", autor.get());
            mv.addObject("artigos", artigos);
        } else {
            mv.addObject("errorMessage", "Autor não encontrado");
            mv.setViewName("error");
        }
        return mv;
    }

}
