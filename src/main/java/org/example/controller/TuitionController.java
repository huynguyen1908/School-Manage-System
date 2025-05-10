package org.example.controller;

import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.example.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tuition")
public class TuitionController {
    
    private final TuitionService service;
    
    @Autowired
    public TuitionController(TuitionService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<Tuition> create(@RequestBody Tuition tuition) {
        return new ResponseEntity<>(service.create(tuition), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Tuition> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Tuition>> getByStatus(@PathVariable TuitionStatus status) {
        return ResponseEntity.ok(service.getByStatus(status));
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Tuition> updateStatus(
            @PathVariable String id, 
            @RequestParam TuitionStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }
    
    @PutMapping("/{id}/pay")
    public ResponseEntity<Tuition> markAsPaid(@PathVariable String id) {
        return ResponseEntity.ok(service.markAsPaid(id, LocalDateTime.now()));
    }
}
