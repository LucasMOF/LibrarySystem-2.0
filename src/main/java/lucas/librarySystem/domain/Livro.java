package lucas.librarySystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "livro")
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;
    private String autor;
    private int numeroPaginas;

    @Column(unique = true)
    private Long code;

    private boolean disponivel;
    private int qtdDisponivel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

}
