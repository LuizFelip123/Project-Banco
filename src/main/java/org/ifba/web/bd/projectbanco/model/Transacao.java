package org.ifba.web.bd.projectbanco.model;

import java.util.Date;
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
public abstract class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;  

    private Date dataTransacao;
    private int quantidade;
    @OneToMany
    private List<ProdutoAlocado> produtosAlocados;


}
