package com.crx.Magazine.Service;

import com.crx.Magazine.Models.Entities.Artigo;

import java.util.List;

public interface ArtigoService {
    List<Artigo> findAll();
    Artigo findById(Integer id);
    List<Artigo> findByTitulo(String titulo);
    Artigo save(Artigo artigo);
}
