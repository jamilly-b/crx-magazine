package com.crx.Magazine.Models.Entities;

import jakarta.persistence.*;
        import java.util.List;

@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String senha;
    private String nome;
    private String icone;
    private String descricaoUsuario;
    private boolean escritor;

    @OneToMany(mappedBy = "escritor")
    private List<Artigo> artigos;
}
