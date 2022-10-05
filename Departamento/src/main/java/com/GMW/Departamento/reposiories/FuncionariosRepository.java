package com.GMW.Departamento.reposiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GMW.Departamento.Domain.Funcionarios;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios,Integer> {
    
    @Query("SELECT f_obj FROM Funcionarios f_obj WHERE f_obj.departamentos.id =: pIdDepto  ORDER BY nm_fucionario")
    List<Funcionarios> findAllByDepto(@Param(value = "pIdDepto") Integer pIdDepto);

    
}
