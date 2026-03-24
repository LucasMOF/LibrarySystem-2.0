package lucas.librarySystem.controller;

import lucas.librarySystem.domain.Livro;
import lucas.librarySystem.dto.RequestLivroDTO;
import lucas.librarySystem.dto.ResponseLivroDTO;
import lucas.librarySystem.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody RequestLivroDTO dto) {
        Livro livro = livroService.registrarLivro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }

    @GetMapping
    public ResponseEntity<List<ResponseLivroDTO>> listarLivrosDisponiveis(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<ResponseLivroDTO> getLivros= livroService.listarLivroDisponiveis(page, size);
        return ResponseEntity.ok(getLivros);
    }
}
