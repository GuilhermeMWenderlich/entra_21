package com.GMW.Departamento.Controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GMW.Departamento.Domain.Departamentos;
import com.GMW.Departamento.Domain.Funcionarios;
import com.GMW.Departamento.reposiories.DepartametoRepository;
import com.GMW.Departamento.reposiories.FuncionariosRepository;
import com.GMW.Departamento.services.ObjectNotFound;

@RestController
@RequestMapping(value = "/departamentos")
public class GeneralControllers {

    @Autowired
    private DepartametoRepository departametoRepository;

    @Autowired
    private FuncionariosRepository fRepository;

    @GetMapping
    public ResponseEntity<List<Departamentos>> findAll(){
       List<Departamentos> departamentos=departametoRepository.findAll();
       return ResponseEntity.ok().body(departamentos);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Departamentos>> findByid(@PathVariable Integer id){
        Optional<Departamentos> departamentos=departametoRepository.findById(id);
        return ResponseEntity.ok().body(departamentos);
    }

    @PostMapping
    public ResponseEntity<Departamentos> insDepto(@Valid @RequestBody Departamentos pDepartamentos){
        
        pDepartamentos.setId_depto(null);
        departametoRepository.save(pDepartamentos);
        URI vURI= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
        buildAndExpand(pDepartamentos.getId_depto()).toUri();
        return ResponseEntity.created(vURI).body(pDepartamentos);

    }

    /*@PutMapping(value = "/{id}")
    public ResponseEntity<Departamentos> updDepto(@Valid @PathVariable Integer id
    @RequestBody Departamentos pDepartamentos){

        Optional<Departamentos> antigoDepartamento= departametoRepository.findById(id);
        antigoDepartamento.set
    }/*/ 
    @DeleteMapping(value ="/{pId}")
    public ResponseEntity<Void>delDepartamento(@PathVariable Integer pId){

        departametoRepository.deleteById(pId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Departamentos> upDepto(@Valid @PathVariable Integer id,@RequestBody Departamentos nDepto){
        
        Departamentos atualDepto=departametoRepository.findById(id).orElseThrow(
            () -> new ObjectNotFound("Departamento Não encontrado")
        );
        atualDepto.setNm_depto(nDepto.getNm_depto());
        departametoRepository.save(atualDepto);
        return ResponseEntity.ok().body(atualDepto);
    }

    @GetMapping(value = "/{id}/funcionarios")
    public ResponseEntity<List<Funcionarios>> findAllByDepto(@PathVariable Integer id){

        return ResponseEntity.ok().body(fRepository.findAllByDepto(id));
    }

}
