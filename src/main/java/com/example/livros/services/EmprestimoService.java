package com.example.livros.services;

import com.example.livros.model.Emprestimo;
import com.example.livros.model.Livro;
import com.example.livros.model.Usuario;
import com.example.livros.repository.EmprestimoRepository;
import com.example.livros.repository.LivroRepository;
import com.example.livros.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com ID: " + id));
    }

    public Emprestimo criarEmprestimo(Long livroId, Long usuarioId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + livroId));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(null);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolverLivro(Long emprestimoId) {
        Emprestimo emprestimo = buscarPorId(emprestimoId);
        emprestimo.setDataDevolucao(LocalDate.now());
        return emprestimoRepository.save(emprestimo);
    }

    public void deletarEmprestimo(Long id) {
        Emprestimo emprestimo = buscarPorId(id);
        emprestimoRepository.delete(emprestimo);
    }

    public List<Emprestimo> buscarPorUsuarioNome(String usuarioNome) {
        return emprestimoRepository.findByUsuarioUsername(usuarioNome);
    }

    public List<Emprestimo> buscarPorLivroNome(String livroNome) {
        return emprestimoRepository.findByLivroTitulo(livroNome);
    }
}
