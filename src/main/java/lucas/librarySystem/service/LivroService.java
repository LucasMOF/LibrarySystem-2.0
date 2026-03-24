package lucas.librarySystem.service;

import lucas.librarySystem.domain.Livro;
import lucas.librarySystem.dto.RequestLivroDTO;
import lucas.librarySystem.dto.ResponseLivroDTO;
import lucas.librarySystem.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ResponseLivroDTO> listarLivroDisponiveis(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Livro> pageLivros = this.livroRepository.findAll(pageable);
        return pageLivros.stream()
                .filter(Livro::isDisponivel)
                .map(livro -> new ResponseLivroDTO(livro.getId(),
                        livro.getTittle(),
                        livro.getAutor(),
                        livro.getNumeroPaginas(),
                        livro.getCode(),
                        livro.isDisponivel(),
                        livro.getQtdDisponivel()))
                .toList();
    }
}
