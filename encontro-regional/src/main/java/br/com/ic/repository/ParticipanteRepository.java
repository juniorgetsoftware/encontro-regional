package br.com.ic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ic.model.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
