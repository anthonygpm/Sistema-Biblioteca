package com.example.livros.controller;

import com.example.livros.dto.CategoriaDTO;
import com.example.livros.model.Categoria;
import com.example.livros.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) { this.categoriaService = categoriaService; }

    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria salvar(@RequestBody @Valid CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        return categoriaService.salvar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar (@PathVariable Long id, @RequestBody @Valid CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNome(dto.getNome());

        return categoriaService.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        categoriaService.deletarPorId(id);
    }
}
