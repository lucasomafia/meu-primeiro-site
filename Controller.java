package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class Controller {
    private TarefaService tarefaService;

    public Controller(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }
    @GetMapping
    public ArrayList<Tarefa> mostrarTarefas(){
        return tarefaService.mostrarTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable UUID id){
                return tarefaService.buscarTarefa(id);
    }

    @PostMapping
    public Tarefa adicionTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.adicionarTarefa(tarefa);
    }
    @DeleteMapping("/{id}")
    public void removerTarefa(@PathVariable UUID id){
            tarefaService.removerTarefa(id);
    }
    @PutMapping("/{id}")
    public Tarefa editarTarefa(@PathVariable UUID id,@RequestBody Tarefa tarefa){
        return tarefaService.editarTarefa(id, tarefa);
    }
}

