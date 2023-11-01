package com.br.Adopet_challenge_backend.controller;

import com.br.Adopet_challenge_backend.dto.TutorDto;
import com.br.Adopet_challenge_backend.model.Tutor;
import com.br.Adopet_challenge_backend.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody @Valid TutorDto tutorDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tutorService.saveTutor(tutorDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTutorById(@PathVariable(value = "id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tutorService.searchTutorById(id));
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> getListOfTutors(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tutorService.getAllTutors());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable(value = "id") Long id,
                                             @RequestBody TutorDto tutorDto){
        tutorDto.setUidTutor(id);
        return ResponseEntity.status(HttpStatus.OK).body(tutorService.updateTutor(tutorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTutor(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(tutorService.deleteTutor(id));
    }

}
