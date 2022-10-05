package com.GMW.Departamento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.GMW.Departamento.Domain.Departamentos;
import com.GMW.Departamento.Domain.Funcionarios;
import com.GMW.Departamento.reposiories.DepartametoRepository;
import com.GMW.Departamento.reposiories.FuncionariosRepository;

@SpringBootApplication
public class DepartamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartamentoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(DepartametoRepository deptoRep,FuncionariosRepository funcRep ){
		
		return(args)->{
			Departamentos depto1= new Departamentos( null,"Produção");
			Departamentos depto2=new Departamentos( null,"Finanças");
			deptoRep.save(depto1);
			deptoRep.save(depto2);
			funcRep.save(new Funcionarios(null,"Guilherme",depto1));
			funcRep.save(new Funcionarios(null,"Ana",depto1));
			funcRep.save(new Funcionarios(null,"Bea",depto2));
			funcRep.save(new Funcionarios(null,"Matheus",depto2));
			funcRep.save(new Funcionarios(null,"Nathan",depto2));
			funcRep.save(new Funcionarios(null,"Vitor",depto1));
		};

	}

}
