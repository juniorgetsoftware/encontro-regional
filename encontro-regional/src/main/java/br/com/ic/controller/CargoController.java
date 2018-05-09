package br.com.ic.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ic.event.RecursoCriadorEvent;
import br.com.ic.model.Cargo;
import br.com.ic.repository.CargoRepository;
import br.com.ic.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private CargoService cargoService;

	@GetMapping
	public Page<Cargo> pesquisar(String nome, Pageable pageable) {
		return cargoRepository.findByNomeContainsOrderByNomeAsc(nome, pageable);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Cargo cargo, HttpServletResponse response) {
		cargo = cargoRepository.save(cargo);
		publisher.publishEvent(new RecursoCriadorEvent(this, response, cargo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		Cargo cargo = cargoRepository.findOne(id);
		return cargo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cargo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cargoRepository.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @Valid @RequestBody Cargo cargo) {
		Cargo cargoBanco = cargoService.atualizar(id, cargo);
		return ResponseEntity.ok(cargoBanco);
	}

	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		cargoService.atualizarPropriedadeAtivo(id, ativo);
	}

}