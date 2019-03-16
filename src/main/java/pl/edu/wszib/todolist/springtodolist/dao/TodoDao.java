package pl.edu.wszib.todolist.springtodolist.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.model.Todo;

import java.util.List;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {
    List<Todo> findAll();
    List<Todo> findTop5ByStatusIsNotOrderByDueDate(Status status);
    int countTodoByStatus(Status status);
    List<Todo> findAllByStatus(Status status);

    //@Query("Select t from Todo t where t.status not like 'COMPLETED' order by t.dueDate desc")
    //List<Todo> query();
}
