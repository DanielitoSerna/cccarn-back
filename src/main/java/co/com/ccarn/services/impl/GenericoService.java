package co.com.ccarn.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.GenericoDto;

@Service
public class GenericoService {

	@Autowired
	private EntityManager em;

	@Transactional
	public List<?> listarDatos(GenericoDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select o from ").append(dto.getTabla()).append(" o ");
		if (dto.getWhere() != null) {
			sql.append(" where ").append(dto.getWhere());
		}
		if (dto.getOrden() != null && dto.getCampoOrden() != null) {
			sql.append(" order by ").append(dto.getCampoOrden()).append(" ").append(dto.getOrden());
		}
		Query query = em.createQuery(sql.toString());
		return query.setFirstResult(dto.getPagina()).setMaxResults(dto.getCantidad()).getResultList();
	}

	@Transactional
	public long contarDatos(GenericoDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(0) from ").append(dto.getTabla()).append(" o ");
		if (dto.getWhere() != null) {
			sql.append(" where ").append(dto.getWhere());
		}
		Query query = em.createQuery(sql.toString());
		return ((Number) query.getSingleResult()).longValue();
	}

}
