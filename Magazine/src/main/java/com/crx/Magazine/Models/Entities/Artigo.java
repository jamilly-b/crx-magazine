package com.crx.Magazine.Models.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ARTIGO")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String titulo;
    private String subtitulo;
    @NotNull
    @Lob
    private String conteudo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataPublicacao;
    private int curtidas;
    @ManyToOne
    @JoinColumn(name = "escritor_id")
    @NotNull
    private User escritor;

    @OneToMany(mappedBy = "artigo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentarios> comentarios = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "TB_ARTIGO_CATEGORIA",
            joinColumns = @JoinColumn(name = "artigo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categorias> categorias = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public User getEscritor() {
        return escritor;
    }

    public void setEscritor(User escritor) {
        this.escritor = escritor;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Categorias> getCategoria() {
        return categorias;
    }

    public void setCategoria(List<Categorias> categoria) {
        this.categorias = categoria;
    }
}
