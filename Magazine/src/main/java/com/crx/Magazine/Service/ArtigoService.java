package com.crx.Magazine.Service;

import com.crx.Magazine.Models.Entities.Artigo;

import java.util.List;
import java.util.Optional;

public interface ArtigoService {
    List<Artigo> findAll();
    Optional<Artigo> findById(Integer id);
    List<Artigo> findByTitulo(String titulo);
    Artigo save(Artigo artigo);
}
