package com.crx.Magazine.Models.Repository;

import com.crx.Magazine.Models.Entities.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrxMagazineRepository extends JpaRepository<Artigo, Integer> {
    List<Artigo> findByTitulo(String titulo);
}
