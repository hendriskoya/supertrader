package br.com.supertrader.controller;

import br.com.supertrader.model.Todo;
import br.com.supertrader.repository.TodoRepository;
import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> post(@RequestParam("description") String description) {
        Todo todo = new Todo();
        todo.setDescription(description);
        todo = todoRepository.save(todo);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> get(@PathVariable("id") Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
