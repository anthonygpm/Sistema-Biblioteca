package com.example.livros.controller;

import com.example.livros.model.Emprestimo;
import com.example.livros.services.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController (EmprestimoService emprestimoService) { this.emprestimoService = emprestimoService; }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscarPorId(@PathVariable Long id) {
        return emprestimoService.buscarPorId(id);
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
    public List<Emprestimo> buscarPorUsuario(@RequestParam String usuarioNome) {
        return emprestimoService.buscarPorUsuarioNome(usuarioNome);
    }

    @GetMapping("/filtrar-livro")
    public List<Emprestimo> buscarPorLivro(@RequestParam String livroNome) {
        return emprestimoService.buscarPorLivroNome(livroNome);
    }
}
