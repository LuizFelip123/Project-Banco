package org.ifba.web.bd.projectbanco.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProdutoAlocado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 

    @ManyToOne
    private Produto produto;
    
    @OneToOne 
    private Filial filial; 

    private int quantidade; 
}
