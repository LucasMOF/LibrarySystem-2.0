package lucas.librarySystem.controller;

import lucas.librarySystem.domain.Emprestimo;
import lucas.librarySystem.dto.RequestEmprestimoDTO;
import lucas.librarySystem.dto.ResponseEmprestimoDTO;
import lucas.librarySystem.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<Emprestimo> realizarEmprestimo(@RequestBody RequestEmprestimoDTO dto) {
        Emprestimo emprestimo = bibliotecaService.realizarEmprestimo(dto.cpf(), dto.code());
        return ResponseEntity.ok(emprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> finalizarEmprestimo(@PathVariable Long id) {
        Emprestimo finalizarEmprestimo = bibliotecaService.finalizarEmprestimo(id);
        return ResponseEntity.ok(finalizarEmprestimo);
    }

    @GetMapping
    ResponseEntity<List<ResponseEmprestimoDTO>> getEmprestimo(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<ResponseEmprestimoDTO> list = bibliotecaService.getEmprestimosAtivos(page, size);
        return ResponseEntity.ok(list);
    }
}
