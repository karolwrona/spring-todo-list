package pl.edu.wszib.todolist.springtodolist.service;

import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll();
    List<TodoDTO> findTop5();
    List<TodoDTO> search(Status status);
    TodoDTO find(Integer id);
    TodoDTO add(TodoDTO dto);
    TodoDTO update(TodoDTO dto);
    TodoDTO delete(Integer id);
    int count(Status status);
}
