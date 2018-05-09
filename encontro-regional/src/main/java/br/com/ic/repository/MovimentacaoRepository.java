package br.com.ic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ic.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
