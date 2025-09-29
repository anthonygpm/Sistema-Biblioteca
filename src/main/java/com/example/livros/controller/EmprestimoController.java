package com.example.livros.controller;

import com.example.livros.dto.emprestimo.EmprestimoResponseDTO;
import com.example.livros.model.Emprestimo;
import com.example.livros.services.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @GetMapping
    public List<EmprestimoResponseDTO> listarTodos() {
        return emprestimoService.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmprestimoResponseDTO buscarPorId(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.buscarPorId(id);
        return toDTO(emprestimo);
    }

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestParam Long livroId, @RequestParam Long usuarioId) {
        return emprestimoService.criarEmprestimo(livroId, usuarioId);
    }

    @PutMapping("/{id}/devolver")
    public Emprestimo devolverLivro(@PathVariable Long id) {
        return emprestimoService.devolverLivro(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
    }

    @GetMapping("/filtrar-usuario")
    public List<EmprestimoResponseDTO> buscarPorUsuario(@RequestParam String usuarioNome) {
        return emprestimoService.buscarPorUsuarioNome(usuarioNome)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtrar-livro")
    public List<EmprestimoResponseDTO> buscarPorLivro(@RequestParam String livroNome) {
        return emprestimoService.buscarPorLivroNome(livroNome)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EmprestimoResponseDTO toDTO(Emprestimo emprestimo) {
        return new EmprestimoResponseDTO(
                emprestimo.getLivro().getId(),
                emprestimo.getUsuario().getId(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }
}
