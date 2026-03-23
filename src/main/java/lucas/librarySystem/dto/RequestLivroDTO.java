package lucas.librarySystem.dto;

public record RequestLivroDTO(String tittle, String autor, int numeroPaginas, Long code, boolean disponivel,
                              int qtdDisponivel) {
}
