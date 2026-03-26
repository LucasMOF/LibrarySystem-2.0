package lucas.librarySystem.dto;

import lucas.librarySystem.domain.Livro;
import lucas.librarySystem.domain.User;

import java.time.LocalDateTime;

public record ResponseEmprestimoDTO(Long id, boolean ativo, LocalDateTime dataDevolucao, LocalDateTime dataEmprestimo, Livro livroId, User userId) {
}
