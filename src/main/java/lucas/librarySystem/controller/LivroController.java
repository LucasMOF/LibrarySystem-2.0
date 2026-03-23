package lucas.librarySystem.controller;

import lucas.librarySystem.domain.Livro;
import lucas.librarySystem.dto.RequestLivroDTO;
import lucas.librarySystem.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody RequestLivroDTO dto){
        Livro livro = livroService.registrarLivro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }
}
