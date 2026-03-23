package lucas.librarySystem.dto;

import lucas.librarySystem.domain.UserType;

public record RequestUserDTO(String name, String cpf, UserType userType) {
}
