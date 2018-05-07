package br.com.ic.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ic.model.Cargo;
import br.com.ic.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public Cargo atualizar(Long id, @Valid Cargo cargo) {
		Cargo cargoBanco = buscarPorId(id);
		BeanUtils.copyProperties(cargo, cargoBanco, "id");
		return cargoRepository.save(cargoBanco);
	}

	private Cargo buscarPorId(Long id) {
		Cargo cargoBanco = cargoRepository.findById(id).get();
		if (cargoBanco == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cargoBanco;
	}

	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Cargo cargoBanco = buscarPorId(id);
		cargoBanco.setAtivo(ativo);
		cargoRepository.save(cargoBanco);
	}

}
