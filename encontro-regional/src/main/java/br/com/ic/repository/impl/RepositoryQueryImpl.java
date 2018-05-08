package br.com.ic.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.ic.repository.filter.Filter;
import br.com.ic.repository.query.RepositoryQuery;

public class RepositoryQueryImpl<T> implements RepositoryQuery<T> {

	@SuppressWarnings("unchecked")
	public RepositoryQueryImpl() throws Exception {
		clazz = ((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Autowired
	private EntityManager entityManager;

	private Class<T> clazz;

	
	public Page<T> filtrar(Filter filter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);

		Root<T> root = criteriaQuery.from(clazz);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteriaQuery.where(predicates);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		adicionarRestricoesDePaginacao(typedQuery, pageable);

		return new PageImpl<>(typedQuery.getResultList(), pageable, total(filter));
	}

	private Long total(Filter filter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<T> root = criteria.from(clazz);

		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return entityManager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<T> typedQuery, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;

		typedQuery.setFirstResult(primeiroRegistroDaPagina);
		typedQuery.setMaxResults(totalDeRegistrosPorPagina);

	}

	private Predicate[] criarRestricoes(Filter filter, CriteriaBuilder builder, Root<T> root) {
		List<Predicate> predicates = restricoes();
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	public List<Predicate> restricoes() {
		throw new RuntimeException("É necessário sobrescrever o método \'public List<Predicate> restricoes()\' e fazê-lo retornar suas restrições.");
	}

}
