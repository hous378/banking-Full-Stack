package tn.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.biat.domain.Operation;

// on aura pas besoin de @repository , enablerepositories active avec JpaRepository

public interface IOperationRepository extends JpaRepository<Operation, Long>{

}
