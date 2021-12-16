package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reqs")
public class NotificationRestController {

    private final HashMap<String, String> memory = new HashMap<>();

    @PostMapping
    public ResponseEntity<Void> post(@RequestHeader Map<String, String> headers, @RequestBody String body) {
        memory.put(body, headers.toString());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<HashMap<String, String>> list() {
        return ResponseEntity.ok(memory);
    }
}
