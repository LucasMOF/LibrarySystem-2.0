package lucas.librarySystem.service;

import lucas.librarySystem.domain.Livro;
import lucas.librarySystem.dto.RequestLivroDTO;
import lucas.librarySystem.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro registrarLivro(RequestLivroDTO dto) {
        Livro newLivro = new Livro();

        newLivro.setTittle(dto.tittle());
        newLivro.setAutor(dto.autor());
        newLivro.setCode(dto.code());
        newLivro.setDisponivel(dto.disponivel());
        newLivro.setNumeroPaginas(dto.numeroPaginas());
        newLivro.setQtdDisponivel(dto.qtdDisponivel());

        livroRepository.save(newLivro);
        return newLivro;
    }

    public boolean livroDisponivel(Livro livro) {
        return livro.getQtdDisponivel() > 0;
    }
}
