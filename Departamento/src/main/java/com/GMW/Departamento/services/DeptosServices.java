package com.GMW.Departamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMW.Departamento.exceptions.DataIntegrityViolationException;
import com.GMW.Departamento.reposiories.DepartametoRepository;

@Service
public class DeptosServices {

    @Autowired
    DepartametoRepository deptoReposotory;

    public void deLDepartamento(Integer pId){

        try {
            deptoReposotory.deleteById(pId);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Departamento não pode ser deleado! Possui funcionarios admitidos");
        }
    }
    
}
