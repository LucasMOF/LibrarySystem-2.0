package lucas.librarySystem.service;

import jakarta.transaction.Transactional;
import lucas.librarySystem.domain.Emprestimo;
import lucas.librarySystem.domain.Livro;
import lucas.librarySystem.domain.User;
import lucas.librarySystem.dto.RequestEmprestimoDTO;
import lucas.librarySystem.repository.EmprestimoRepository;
import lucas.librarySystem.repository.LivroRepository;
import lucas.librarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LivroService livroService;

    @Transactional
    public Emprestimo realizarEmprestimo(String cpf, Long code) {
        User user = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livro livro = livroRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!userService.emprestimoOk(user)) {
            throw new RuntimeException("Limite de empréstimos atingido");
        }
        if (!livroService.livroDisponivel(livro)) {
            throw new RuntimeException("Livro indisponível");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUser(user);
        emprestimo.setLivro(livro);

        user.setQtdEmprestimosAtivos(user.getQtdEmprestimosAtivos() + 1);
        livro.setQtdDisponivel(livro.getQtdDisponivel() - 1);

        userRepository.save(user);
        livroRepository.save(livro);

        return emprestimoRepository.save(emprestimo);

    }
}
