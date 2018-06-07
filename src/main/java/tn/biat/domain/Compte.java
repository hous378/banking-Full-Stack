package tn.biat.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comptes")
@Data
@AllArgsConstructor // Lombork getter and setter and constructors
@NoArgsConstructor
public class Compte {

	@Id
	private String numero;
	private String prop;
	private BigDecimal solde;
	
	// pour ignorer les donnes des operation lorsque on get le compte 
	@JsonIgnore
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;
}
