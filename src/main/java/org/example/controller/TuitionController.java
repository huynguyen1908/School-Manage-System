//package org.example.controller;
//
//import org.example.dto.request.CreateTuitionRequest;
//import org.example.dto.request.PayTuitionRequest;
//import org.example.dto.request.UpdateTuitionRequest;
//import org.example.entity.Tuition;
//import org.example.service.TuitionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/tuition")
//public class TuitionController {
//
//    @Autowired
//    private TuitionService tuitionService;
//
//    @PostMapping
//    public ResponseEntity<Tuition> createTuition(@RequestBody CreateTuitionRequest request) {
//        Tuition tuition = tuitionService.createTuition(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(tuition);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Tuition>> getAllTuitions(
//            @RequestParam(required = false) String parentId,
//            @RequestParam(required = false) String studentId,
//            @RequestParam(required = false) String status) {
//        List<Tuition> tuitions = tuitionService.getAllTuitions(parentId, studentId, status);
//        return ResponseEntity.ok(tuitions);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Tuition> getTuitionById(@PathVariable String id) {
//        Tuition tuition = tuitionService.getTuitionById(id);
//        return ResponseEntity.ok(tuition);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Tuition> updateTuition(
//            @PathVariable String id,
//            @RequestBody UpdateTuitionRequest request) {
//        Tuition updatedTuition = tuitionService.updateTuition(id, request);
//        return ResponseEntity.ok(updatedTuition);
//    }
//
//    @PostMapping("/{id}/pay")
//    public ResponseEntity<Tuition> payTuition(
//            @PathVariable String id,
//            @RequestBody PayTuitionRequest request) {
//        Tuition tuition = tuitionService.recordPayment(id, request);
//        return ResponseEntity.ok(tuition);
//    }
//
//    @PostMapping("/{id}/remind")
//    public ResponseEntity<Tuition> sendPaymentReminder(@PathVariable String id) {
//        Tuition tuition = tuitionService.sendPaymentReminder(id);
//        return ResponseEntity.ok(tuition);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTuition(@PathVariable String id) {
//        tuitionService.deleteTuition(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/overdue")
//    public ResponseEntity<List<Tuition>> getOverdueTuitions() {
//        List<Tuition> overdueTuitions = tuitionService.getOverdueTuitions();
//        return ResponseEntity.ok(overdueTuitions);
//    }
//
//    @GetMapping("/statistics")
//    public ResponseEntity<Map<String, Object>> getTuitionStatistics(
//            @RequestParam(required = false) String schoolYear,
//            @RequestParam(required = false) String semester) {
//        Map<String, Object> statistics = tuitionService.getTuitionStatistics(schoolYear, semester);
//        return ResponseEntity.ok(statistics);
//    }
//
//    @PostMapping("/bulk-remind")
//    public ResponseEntity<Integer> sendBulkReminders() {
//        int remindersCount = tuitionService.sendBulkReminders();
//        return ResponseEntity.ok(remindersCount);
//    }
//}
