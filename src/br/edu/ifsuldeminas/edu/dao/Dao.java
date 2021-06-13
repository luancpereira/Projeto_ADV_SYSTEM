package br.edu.ifsuldeminas.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class Dao<T> {
		
		private final Class<T> classe;
		
	public Dao(Class classe){
		this.classe = classe;
	}
	
	public void adiciona(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void remove(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		T t = em.find(classe, id);
		em.remove(t);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void atualiza(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(t);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public T listaPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		T t = em.find(classe, id);
		
		em.close();
		
		return t;
	}
	
	public List<T> listaTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = " SELECT t FROM " + classe.getName() + " t ";
		
		TypedQuery<T> query = em.createQuery(jpql, classe);
		
		List<T> lista = query.getResultList();
		
		em.close();
		
		return lista;
	}
	
//	public List<Dependente> listaTodos(Socio s) {
//		EntityManager em = JPAUtil.getEntityManager();
		
//		String jpql = "SELECT d FROM Dependente d WHERE d.socio = :pSocio";
		
//		TypedQuery<Dependente> query = em.createQuery(jpql, Dependente.class);
//		query.setParameter("pSocio", s);
		
//		List<Dependente> lista = query.getResultList();
		
//		em.close();
		
//		return lista;
//	}
	
	
}
