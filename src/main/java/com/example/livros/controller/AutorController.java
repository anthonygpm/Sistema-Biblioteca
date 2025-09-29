package com.example.livros.controller;

import com.example.livros.dto.autor.AutorRequestDTO;
import com.example.livros.dto.autor.AutorResponseDTO;
import com.example.livros.model.Autor;
import com.example.livros.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<AutorResponseDTO> buscarAutores(){
        return autorService.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AutorResponseDTO buscarPorId(@PathVariable Long id){
        Autor autor = autorService.buscarPorId(id);
        return toDTO(autor);
    }

    @PostMapping
    public AutorResponseDTO salvar(@RequestBody @Valid AutorRequestDTO dto){
        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setBiografia(dto.biografia());
        autor.setNacionalidade(dto.nacionalidade());

        Autor autorSalvo = autorService.salvar(autor);
        return toDTO(autorSalvo);
    }

    @PutMapping("/{id}")
    public AutorResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid AutorRequestDTO dto){
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNome(dto.nome());
        autor.setBiografia(dto.biografia());
        autor.setNacionalidade(dto.nacionalidade());

        Autor autorAtualizado = autorService.atualizar(autor);
        return toDTO(autorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        autorService.deletarPorId(id);
    }

    public AutorResponseDTO toDTO(Autor autor){
        return new AutorResponseDTO(
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getBiografia()
        );
    }
}
