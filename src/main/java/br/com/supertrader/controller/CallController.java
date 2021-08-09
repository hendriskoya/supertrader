package br.com.supertrader.controller;

import br.com.supertrader.model.Call;
import br.com.supertrader.service.CallService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calls")
public class CallController {

    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @PostMapping
    public ResponseEntity<Call> post(@RequestBody CallCreationRequest callCreationRequest) {
        Call call = callService.createCall(callCreationRequest);
        return ResponseEntity.ok(call);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Call> put(@PathVariable("id") Integer id, @RequestBody CallUpdateRequest callUpdateRequest) {
        Call call = callService.updateCall(id, callUpdateRequest);

        return ResponseEntity.ok(call);
    }

    @GetMapping
    public ResponseEntity<Iterable<Call>> getAll() {
        return ResponseEntity.ok(callService.findAll());
    }

    @GetMapping("/{stock}")
    public ResponseEntity<Call> getByStock(@PathVariable("stock") String stock) {
        Optional<Call> call = callService.findByStock(stock);
        if (call.isPresent()) {
            return ResponseEntity.ok(call.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
