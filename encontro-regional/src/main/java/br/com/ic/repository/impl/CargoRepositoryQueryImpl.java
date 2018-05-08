package br.com.ic.repository.impl;

import java.util.ArrayList;
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
import org.springframework.util.StringUtils;

import br.com.ic.model.Cargo;
import br.com.ic.repository.filter.CargoFilter;
import br.com.ic.repository.query.CargoRepositoryQuery;

public class CargoRepositoryQueryImpl implements CargoRepositoryQuery {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Page<Cargo> filtrar(CargoFilter cargoFilter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cargo> criteriaQuery = builder.createQuery(Cargo.class);

		Root<Cargo> root = criteriaQuery.from(Cargo.class);
		Predicate[] predicates = criarRestricoes(cargoFilter, builder, root);
		criteriaQuery.where(predicates);

		
		TypedQuery<Cargo> typedQuery = entityManager.createQuery(criteriaQuery);

		adicionarRestricoesDePaginacao(typedQuery, pageable);
		
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, total(cargoFilter));
	}

	private Long total(CargoFilter cargoFilter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Cargo> root = criteria.from(Cargo.class);
		
		Predicate[] predicates = criarRestricoes(cargoFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return entityManager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Cargo> typedQuery, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		typedQuery.setFirstResult(primeiroRegistroDaPagina);
		typedQuery.setMaxResults(totalDeRegistrosPorPagina);
		
	}

	private Predicate[] criarRestricoes(CargoFilter cargoFilter, CriteriaBuilder builder, Root<Cargo> root) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(cargoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + cargoFilter.getNome().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
