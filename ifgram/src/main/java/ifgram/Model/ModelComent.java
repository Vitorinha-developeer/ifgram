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

}
