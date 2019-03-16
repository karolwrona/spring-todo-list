package pl.edu.wszib.todolist.springtodolist.service;

import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll();
    List<TodoDTO> findTop5();
    TodoDTO find(Integer id);
    TodoDTO add(TodoDTO dto);
    TodoDTO update(TodoDTO dto);
    TodoDTO delete(Integer id);
}
