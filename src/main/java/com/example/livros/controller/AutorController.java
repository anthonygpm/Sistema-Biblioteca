package com.example.livros.controller;

import com.example.livros.dto.AutorDTO;
import com.example.livros.model.Autor;
import com.example.livros.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> buscarAutores(){
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Long id){
        return autorService.buscarPorId(id);
    }

    @PostMapping
    public Autor salvar(@RequestBody @Valid AutorDTO dto){
        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        autor.setBiografia(dto.getBiografia());
        autor.setNacionalidade(dto.getNacionalidade());
        return autorService.salvar(autor);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody @Valid AutorDTO dto){
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNome(dto.getNome());
        autor.setBiografia(dto.getBiografia());
        autor.setNacionalidade(dto.getNacionalidade());
        return autorService.atualizar(autor);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        autorService.deletarPorId(id);
    }
}
