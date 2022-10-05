package com.GMW.Departamento.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
public class Departamentos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_depto;

    @NotEmpty(message = "Campo NM_DEPTO não pode ser vazio!")
    @Length(min = 5,max = 100, message = "Campo NM_DEPTO deve ter entre 5 e 100 digitos")
    private String nm_depto;

    @OneToMany(mappedBy = "departamentos")
    private List<Funcionarios> Funcionarios=new ArrayList<>();

    public Departamentos(){

    }

public Departamentos(Integer id_depto, String nm_depto) {
        this.id_depto = id_depto;
        this.nm_depto = nm_depto;
    }

    public Integer getId_depto() {
        return id_depto;
    }
    public void setId_depto(Integer id_depto) {
        this.id_depto = id_depto;
    }
    public String getNm_depto() {
        return nm_depto;
    }
    public void setNm_depto(String nm_depto) {
        this.nm_depto = nm_depto;
    }

    
}
