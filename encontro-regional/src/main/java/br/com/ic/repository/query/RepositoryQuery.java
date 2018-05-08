package br.com.ic.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ic.repository.filter.Filter;

public interface RepositoryQuery<T> {

	public Page<T> filtrar(Filter filter, Pageable pageable);

}
