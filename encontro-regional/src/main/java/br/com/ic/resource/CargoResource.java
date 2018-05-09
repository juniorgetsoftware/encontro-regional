package br.com.ic.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class CargoResource {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private CargoService cargoService;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CARGO') and #oauth2.hasScope('read')")
	public List<Cargo> listar() {
		return cargoRepository.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CARGO') and #oauth2.hasScope('write')")
	public ResponseEntity<?> criar(@Valid @RequestBody Cargo cargo, HttpServletResponse response) {
		cargo = cargoRepository.save(cargo);
		publisher.publishEvent(new RecursoCriadorEvent(this, response, cargo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CARGO') and #oauth2.hasScope('read')")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Cargo cargo = cargoRepository.findOne(id);
		return cargo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cargo);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_CARGO') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		cargoRepository.delete(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CARGO') and #oauth2.hasScope('write')")
	public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @Valid @RequestBody Cargo cargo) {
		Cargo cargoBanco = cargoService.atualizar(id, cargo);
		return ResponseEntity.ok(cargoBanco);
	}

	@PutMapping("/{id}/ativo")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CARGO') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		cargoService.atualizarPropriedadeAtivo(id, ativo);
	}

}