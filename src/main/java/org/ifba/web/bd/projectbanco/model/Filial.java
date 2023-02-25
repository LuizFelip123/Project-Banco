package org.ifba.web.bd.projectbanco.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 

    private String cidade;
    private String rua;
    private String email;
    private String bairro;
    @OneToMany
    private List<ProdutoAlocado> produtosAlocados;

}
