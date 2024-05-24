package com.crx.Magazine.Service.ServiceImpl;

import com.crx.Magazine.Models.Entities.Artigo;
import com.crx.Magazine.Models.Repository.CrxMagazineRepository;
import com.crx.Magazine.Service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    CrxMagazineRepository magazineRepository;

    @Override
    public List<Artigo> findAll() {
        return magazineRepository.findAll();
    }

    @Override
    public Artigo findById(Integer id) {
        return magazineRepository.getReferenceById(id);
    }

    @Override
    public List<Artigo> findByTitulo(String titulo) {
        return magazineRepository.findByTitulo(titulo);
    }

    @Override
    public Artigo save(Artigo artigo) {
        return magazineRepository.save(artigo);
    }
}
