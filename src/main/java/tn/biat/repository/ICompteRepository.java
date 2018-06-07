package tn.biat.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.biat.domain.Compte;

//@Repository , le fait de exted jpaRepository c est declare dans spring en tant que bean
public interface ICompteRepository extends JpaRepository<Compte, String> {

	List<Compte> findBySoldeIsLessThanEqual(BigDecimal valeur);

	List<Compte> findByPropIsLike(String prop);

	@Query("select c from Compte c  where c.solde <= ?1")
	List<Compte> findBySoldeInferieur(BigDecimal valeur);

	@Query("select c from Compte c where c.prop like %?1%")
	List<Compte> findBypropietaireComme(String pattern);

}
