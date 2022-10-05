package com.GMW.Departamento.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GMW.Departamento.Domain.Funcionarios;
import com.GMW.Departamento.services.FuncSenvices;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncController {

    @Autowired
    private FuncSenvices fServices;

    @GetMapping
    public ResponseEntity<List<Funcionarios>> findAll(){
        List<Funcionarios> funcionarios=fServices.findAll();
        return ResponseEntity.ok().body(funcionarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionarios> findByid(@PathVariable Integer id){
        Funcionarios funcionarios=fServices.findBuid(id);
        return ResponseEntity.ok().body(funcionarios);

    }
}

