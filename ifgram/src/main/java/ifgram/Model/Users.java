package ifgram.Model;

import jakarta.persistence.*;

@Entity
@Table (name="usuarios")

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 120)
    private String nome;

    @Column (nullable = false, unique = true)
    private String email;

    public Users(){

        this.id=id;
        this.email=email;
        this.nome=nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

