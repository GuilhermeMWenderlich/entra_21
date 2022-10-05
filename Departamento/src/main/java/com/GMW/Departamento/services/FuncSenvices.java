package com.GMW.Departamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMW.Departamento.Domain.Funcionarios;
import com.GMW.Departamento.reposiories.FuncionariosRepository;

@Service
public class FuncSenvices {

    @Autowired
    private FuncionariosRepository fRepository;

    public List<Funcionarios> findAll(){
        return fRepository.findAll();
    }
    public Funcionarios findBuid(Integer id){
        Optional<Funcionarios>funcionario=fRepository.findById(id);
        return funcionario.orElseThrow(
            ()->new ObjectNotFound("Objeto não encontrado!Id:"+id+", tipo "+Funcionarios.class.getName())
        );
    }

}
