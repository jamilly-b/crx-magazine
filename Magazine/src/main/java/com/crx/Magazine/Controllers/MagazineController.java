package com.crx.Magazine.Controllers;

import com.crx.Magazine.Models.Entities.Artigo;
import com.crx.Magazine.Models.Repository.CrxMagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MagazineController {

    @Autowired
    CrxMagazineRepository magazineRepository;

    @RequestMapping(value = "/artigos", method = RequestMethod.GET)
    public ModelAndView getArtigos(){
        ModelAndView mv = new ModelAndView("artigos");
        List<Artigo> artigos = magazineRepository.findAll();
        mv.addObject("artigos", artigos);
        return mv;
    }

















}
