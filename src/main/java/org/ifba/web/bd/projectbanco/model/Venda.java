package org.ifba.web.bd.projectbanco.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venda extends Transacao {
    private double valorFinal; 
}
