package lucas.librarySystem.dto;

public record ResponseLivroDTO(Long id, String tittle, String autor, int numeroPaginas, Long code, boolean disponivel,
                               int qtdDisponivel) {
}
