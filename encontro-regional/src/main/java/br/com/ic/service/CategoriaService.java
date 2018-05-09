package br.com.ic.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ic.model.Categoria;
import br.com.ic.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria atualizar(Long id, @Valid Categoria categoria) {
		Categoria categoriaBanco = buscarPorId(id);
		BeanUtils.copyProperties(categoria, categoriaBanco, "id");
		return categoriaRepository.save(categoriaBanco);
	}

	private Categoria buscarPorId(Long id) {
		Categoria categoriaBanco = categoriaRepository.findOne(id);
		if (categoriaBanco == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaBanco;
	}

	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Categoria categoriaBanco = buscarPorId(id);
		categoriaBanco.setAtivo(ativo);
		categoriaRepository.save(categoriaBanco);
	}

}
