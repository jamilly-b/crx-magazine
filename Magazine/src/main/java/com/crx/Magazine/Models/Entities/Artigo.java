import java.util.Date;
import java.util.List;

public class Artigo {

    private String id;
    private String titulo;
    private String subtitulo;
    private String conteudo;
    private Date dataPublicacao;
    private int curtidas;
    private User escritor;
    private List<Comentarios> comentarios;
}
