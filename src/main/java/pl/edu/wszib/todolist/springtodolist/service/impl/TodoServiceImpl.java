package pl.edu.wszib.todolist.springtodolist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.todolist.springtodolist.dao.TodoDao;
import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.model.Todo;
import pl.edu.wszib.todolist.springtodolist.service.TodoService;
import pl.edu.wszib.todolist.springtodolist.utils.ConverterComponent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private ConverterComponent converterComponent;

    @Override
    public List<TodoDTO> findAll() {
       return todoDao.findAll()
                .stream()
                .map(converterComponent::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDTO find(Integer id) {
        return todoDao.findById(id)
                        .map(converterComponent::convert)
                        .orElse(null);
    }

    @Override
    public TodoDTO add(TodoDTO dto) {
        Todo todo = converterComponent.convert(dto);
        todo.setStatus(Status.NEW);
        return converterComponent.convert(todoDao.save(todo));
    }

    @Override
    public TodoDTO update(TodoDTO dto) {
        Todo todo = todoDao.findById(dto.id).orElse(new Todo());
        Todo converted = converterComponent.convert(dto);

        todo.setStatus(converted.getStatus());
        todo.setTitle(converted.getTitle());
        todo.setDueDate(converted.getDueDate());

        return converterComponent.convert(todoDao.save(todo));
    }

    @Override
    public TodoDTO delete(Integer id) {
        Optional<Todo> todo = todoDao.findById(id);
        todo.ifPresent(t->todoDao.delete(t));
        return todo.map(converterComponent::convert).orElse(null);
    }
}
