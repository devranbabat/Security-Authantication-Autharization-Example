package com.example.security_authantication_autharization_example.controller;

import com.example.security_authantication_autharization_example.entity.GerekliBelgeler;
import com.example.security_authantication_autharization_example.service.GerekliBelgelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exam")
@RequiredArgsConstructor
public class GerekliBelgelerController {

    private final GerekliBelgelerService gerekliBelgelerService;

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody GerekliBelgeler gerekliBelgeler){

        return ResponseEntity.ok(gerekliBelgelerService.save(gerekliBelgeler));
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update( @PathVariable int id ,@RequestBody GerekliBelgeler gerekliBelgeler) throws Exception {

        return ResponseEntity.ok(gerekliBelgelerService.update(id,gerekliBelgeler));
    }
}
