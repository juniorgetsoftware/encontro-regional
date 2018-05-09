package br.com.ic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ic.model.Igreja;

public interface IgrejaRepository extends JpaRepository<Igreja, Long> {
}
