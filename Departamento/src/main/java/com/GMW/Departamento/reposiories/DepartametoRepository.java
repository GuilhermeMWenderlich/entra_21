package com.GMW.Departamento.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GMW.Departamento.Domain.Departamentos;

@Repository

public interface DepartametoRepository extends JpaRepository<Departamentos,Integer> {


    
}
