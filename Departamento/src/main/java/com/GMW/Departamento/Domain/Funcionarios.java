package com.GMW.Departamento.Domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Funcionarios implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Func;
    @NotEmpty(message = "Campo NM_DEPTO não pode ser vazio!")
    @Length(min = 3,max = 100, message = "Campo NM_DEPTO deve ter entre 3 e 100 digitos")
    private String nm_Func;

    @ManyToOne
    @JoinColumn(name = "id_depto")
    private Departamentos departamentos;

    public Funcionarios() {
    }

    public Funcionarios(Integer id_Func,
            @NotEmpty(message = "Campo NM_DEPTO não pode ser vazio!") @Length(min = 3, max = 100, message = "Campo NM_DEPTO deve ter entre 3 e 100 digitos") String nm_Func,
            Departamentos departamentos) {
        this.id_Func = id_Func;
        this.nm_Func = nm_Func;
        this.departamentos = departamentos;
    }

    public Integer getId_Func() {
        return id_Func;
    }

    public void setId_Func(Integer id_Func) {
        this.id_Func = id_Func;
    }

    public String getNm_Func() {
        return nm_Func;
    }

    public void setNm_Func(String nm_Func) {
        this.nm_Func = nm_Func;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

   


    
}
