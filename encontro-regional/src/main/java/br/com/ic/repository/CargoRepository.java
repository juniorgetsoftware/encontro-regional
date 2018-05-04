package br.com.ic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ic.model.Cargo;

@RepositoryRestResource
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
