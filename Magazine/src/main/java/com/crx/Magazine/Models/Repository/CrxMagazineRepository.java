package com.crx.Magazine.Models.Repository;

import com.crx.Magazine.Models.Entities.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrxMagazineRepository extends JpaRepository<Artigo, Integer> {
}
