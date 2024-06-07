package com.crx.Magazine.Models.Repository;

import com.crx.Magazine.Models.Entities.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CrxMagazineRepository extends JpaRepository<Artigo, Integer> {
    List<Artigo> findByTitulo(String titulo);
    List<Artigo> findByEscritorId(Integer escritorId);
    @Query("SELECT a FROM Artigo a JOIN FETCH a.escritor WHERE a.id = :id")
    Optional<Artigo> findByIdWithEscritor(@Param("id") Integer id);
}
