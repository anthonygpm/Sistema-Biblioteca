package com.example.livros.controller;

import com.example.livros.dto.Livro.LivroResponseDTO;
import com.example.livros.dto.Livro.LivroRequestDTO;
import com.example.livros.model.Autor;
import com.example.livros.model.Categoria;
import com.example.livros.model.Livro;
import com.example.livros.services.AutorService;
import com.example.livros.services.CategoriaService;
import com.example.livros.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;
    private final CategoriaService categoriaService;
    private final AutorService autorService;

    public LivroController(LivroService livroService, AutorService autorService, CategoriaService categoriaService) {
        this.livroService = livroService;
        this.categoriaService = categoriaService;
        this.autorService = autorService;
    }

    @GetMapping
    public List<LivroResponseDTO> listarTodos() {
        return livroService.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LivroResponseDTO buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        return toDTO(livro);
    }

    @GetMapping("/filtrar-categoria")
    public List<LivroResponseDTO> filtrarPorCategoria(@RequestParam String categoriaNome) {
        return livroService.buscarPorCategoria(categoriaNome)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtrar-autor")
    public List<LivroResponseDTO> buscarPorAutor(@RequestParam String autorNome) {
        return livroService.buscarPorAutor(autorNome)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public LivroResponseDTO salvar(@RequestBody @Valid LivroRequestDTO dto) {
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId());
        Autor autor = autorService.buscarPorId(dto.getAutorId());

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setCategoria(categoria);
        livro.setAutor(autor);
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        Livro salvo = livroService.salvar(livro);
        return toDTO(salvo);
    }

    @PutMapping("/{id}")
    public LivroResponseDTO atualizar (@PathVariable Long id, @RequestBody @Valid LivroRequestDTO dto) {
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId());
        Autor autor =  autorService.buscarPorId(dto.getAutorId());

        Livro livro = new Livro();
        livro.setId(id);
        livro.setTitulo(dto.getTitulo());
        livro.setCategoria(categoria);
        livro.setAutor(autor);
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        Livro salvo = livroService.salvar(livro);
        return toDTO(salvo);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        livroService.deletarPorId(id);
    }

    public LivroResponseDTO toDTO(Livro livro) {
        return new LivroResponseDTO(
                livro.getTitulo(),
                livro.getCategoria().getNome(),
                livro.getAutor().getNome(),
                livro.getAnoPublicacao()
        );
    }
}
