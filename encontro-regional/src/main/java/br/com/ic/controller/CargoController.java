package br.com.ic.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ic.model.Cargo;
import br.com.ic.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cargo cargo) {
		cargo = cargoRepository.save(cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(cargo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@Valid @PathVariable Long id) {
		Cargo cargo = cargoRepository.findById(id).get();
		return cargo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cargo);
	}

}
