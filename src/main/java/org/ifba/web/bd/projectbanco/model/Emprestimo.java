package org.ifba.web.bd.projectbanco.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emprestimo extends Transacao{
    
    private Date dataFimEmprestimo;
}
