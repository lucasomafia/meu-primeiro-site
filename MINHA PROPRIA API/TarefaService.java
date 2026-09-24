package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service 
public class TarefaService {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public Tarefa adicionarTarefa(Tarefa tarefa){
            tarefa.setId(UUID.randomUUID());
            tarefas.add(tarefa);
            return tarefa;
            }
    public ArrayList<Tarefa> mostrarTarefas(){
        return tarefas;
    }
    public Tarefa buscarTarefa(UUID id){
        for(int i = 0;i < tarefas.size();i++){
            if(tarefas.get(i).getId().equals(id)){
                return tarefas.get(i);
            }
        }
        return null;
    }
    public void removerTarefa(UUID id){
        for(int i = 0; i < tarefas.size();i++){
            if(tarefas.get(i).getId().equals(id)){
                tarefas.remove(i);
                break;
            }
        }
    }
    public Tarefa editarTarefa(UUID id,Tarefa tarefa){
        for(int i = 0; i < tarefas.size();i++){
            if(tarefas.get(i).getId().equals(id)){
                tarefa.setId(id);
                tarefas.set(i,tarefa);
                return tarefa;
            }
        }
        return null;
    }
}
