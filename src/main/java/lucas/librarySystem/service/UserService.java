package lucas.librarySystem.service;

import lucas.librarySystem.domain.User;
import lucas.librarySystem.domain.UserType;
import lucas.librarySystem.dto.RequestUserDTO;
import lucas.librarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(RequestUserDTO dto) {
        User newUser = new User();
        newUser.setName(dto.name());
        newUser.setCpf(dto.cpf());
        newUser.setUserType(dto.userType());

        int qtd = switch (dto.userType()) {
            case ALUNO -> 3;
            case PROFESSOR -> 5;
        };
        newUser.setLimiteEmprestimos(qtd);

        userRepository.save(newUser);
        return newUser;
    }

    public boolean emprestimoOk(User user){
        return user.getQtdEmprestimosAtivos() < user.getLimiteEmprestimos();
    }
}
