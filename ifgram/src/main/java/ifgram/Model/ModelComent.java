package ifgram.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="table_coment")

public class ModelComent {

    @Id

    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 300)
    private String texto;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name="Post_id")
    private Post post;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    private Post autor;

    public ModelComent(){}

    public ModelComent (String texto, LocalDateTime criadoEm){

        this.texto=texto;
        this.criadoEm=criadoEm;
    }

    public Long getId (){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Post getAutor() {
        return autor;
    }

    public void setAutor(Post autor) {
        this.autor = autor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
