package br.com.ic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ic.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
