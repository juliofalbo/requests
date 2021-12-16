package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/reqs")
public class NotificationRestController {

    private final HashMap<String, String> memory = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> post(@RequestHeader Map<String, String> headers, @RequestBody String body) {
        memory.put(body, headers.toString());
        return ResponseEntity.ok("Ok");
    }

    @GetMapping
    public ResponseEntity<String> get(@RequestHeader Map<String, String> headers) {
        memory.put(UUID.randomUUID().toString(), headers.toString());
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/list")
    public ResponseEntity<HashMap<String, String>> list() {
        return ResponseEntity.ok(memory);
    }
}
