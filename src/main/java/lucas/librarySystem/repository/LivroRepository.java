package lucas.librarySystem.repository;

import lucas.librarySystem.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByCode(Long code);
}
