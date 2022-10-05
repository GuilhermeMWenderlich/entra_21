package com.GMW.Departamento.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class generalController {
    @GetMapping("/")
    public String index() {
        return "Ola Mundo!!!";
    }
    @PostMapping("/")
        public String IndexPost(){
            return "Agora com Post";
        }
        @GetMapping("/teste")
            public String outroIndex(){
                return "Usando URI teste";  
            }
            @GetMapping("/teste/{parametro}")
            public String indexParametro(@PathVariable Integer parametro){
                return "Voce passou "+parametro.toString()+" como Parametro";
            }

    }
