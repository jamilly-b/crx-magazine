package com.crx.Magazine.util;

import com.crx.Magazine.Models.Entities.Categorias;
import com.crx.Magazine.Models.Entities.Comentarios;
import com.crx.Magazine.Models.Entities.User;
import com.crx.Magazine.Models.Entities.Artigo;
import com.crx.Magazine.Models.Repository.CrxMagazineRepository;
import com.crx.Magazine.Models.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CrxMagazineRepository magazineRepository;
    @Autowired
    UserRepository userRepository;

    //@PostConstruct
    public void criarArtigosDummy() {
        List<Artigo> artigoList = new ArrayList<>();

        // Usuarios
        User user1 = new User();
        user1.setNome("João Ferreira");
        user1.setEmail("joao@example.com");
        user1.setSenha("senha123");
        user1.setDescricaoUsuario("Desenvolvedor Java");

        User user2 = new User();
        user2.setNome("Maria Santiago");
        user2.setEmail("maria@gmail.com");
        user2.setSenha("senha123");
        user2.setDescricaoUsuario("Jornalista e escritora de contos");
        user2.setEscritor(true);

        User user3 = new User();
        user3.setNome("Pedro Costa");
        user3.setEmail("pedro@gmail.com");
        user3.setSenha("senha123");
        user3.setDescricaoUsuario("Engenheiro de soft e escritor");
        user3.setEscritor(true);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Artigos 1
        Artigo artigo1 = new Artigo();
        artigo1.setTitulo("Introdução à Programação");
        artigo1.setSubtitulo("Conceitos básicos para iniciantes");
        artigo1.setImagemArtigo("https://picsum.photos/200/300");
        artigo1.setConteudo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Pellentesque euismod tristique neque, at venenatis metus venenatis vel. " +
                "Integer luctus augue ac lacinia bibendum.");
        artigo1.setDataPublicacao(LocalDate.now());
        artigo1.setCurtidas(10);
        artigo1.setEscritor(user3);

        Artigo artigo2 = new Artigo();
        artigo2.setTitulo("Lorem ipsum dolor sit amet, consectetur");
        artigo2.setSubtitulo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \" +\n" +
                "                \"Pellentesque euismod tristique neque, at");
        artigo2.setImagemArtigo("https://picsum.photos/200/300");
        artigo2.setConteudo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Pellentesque euismod tristique neque, at venenatis metus venenatis vel. " +
                "Integer luctus augue ac lacinia bibendum.");
        artigo2.setDataPublicacao(LocalDate.now());
        artigo2.setCurtidas(23);
        artigo2.setEscritor(user3);


        // Categorias
        List<Categorias> categorias = new ArrayList<>();
//        Categorias categoria1 = new Categorias();
//        categoria1.setNome("Programação");
//        categorias.add(categoria1);
        Categorias categoria2 = new Categorias();
        categoria2.setNome("Lorem");
        artigo2.setCategoria(categorias);

        // Comentários
        List<Comentarios> comentarios = new ArrayList<>();
        Comentarios comentario1 = new Comentarios();
        comentario1.setComentario("Ótimo artigo! Parabéns!");
        comentario1.setUsuario(user1);
        comentario1.setArtigo(artigo1);
        comentarios.add(comentario1);
        artigo1.setComentarios(comentarios);

        artigoList.add(artigo1);
        artigoList.add(artigo2);

        magazineRepository.save(artigo1);
        magazineRepository.save(artigo2);

        System.out.println(artigo1.getId());
        System.out.println(artigo2.getId());
    }
}
