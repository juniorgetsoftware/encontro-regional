package br.com.ic.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ic.model.Cargo;
import br.com.ic.repository.filter.CargoFilter;

public interface CargoRepositoryQuery {

	public Page<Cargo> filtrar(CargoFilter cargoFilter, Pageable pageable);
	
}
