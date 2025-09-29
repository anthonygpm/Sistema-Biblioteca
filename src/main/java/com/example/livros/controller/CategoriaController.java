package com.example.livros.controller;

import com.example.livros.dto.categoria.CategoriaRequestDTO;
import com.example.livros.dto.categoria.CategoriaResponseDTO;
import com.example.livros.model.Categoria;
import com.example.livros.services.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaResponseDTO> listarTodos() {
        return categoriaService.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO buscarPorId(@PathVariable Long id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        return toDTO(categoria);
    }

    @PostMapping
    public Categoria salvar(@RequestBody @Valid CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());
        return categoriaService.salvar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar (@PathVariable Long id, @RequestBody @Valid CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNome(dto.nome());

        return categoriaService.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        categoriaService.deletarPorId(id);
    }

    public CategoriaResponseDTO toDTO(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getNome());
    }
}
