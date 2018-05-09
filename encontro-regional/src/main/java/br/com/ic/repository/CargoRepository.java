package br.com.ic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ic.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	public Page<Cargo> findByNomeContainsOrderByNomeAsc(String nome, Pageable pageable);

}
