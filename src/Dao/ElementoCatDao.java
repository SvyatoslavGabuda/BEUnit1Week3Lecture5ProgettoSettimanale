package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ElementoCatalogo;

import utils.JpaUtil;

public class ElementoCatDao {

	public void salva(ElementoCatalogo a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}
	public ElementoCatalogo getByISBM(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			ElementoCatalogo a = em.find(ElementoCatalogo.class, id);
			em.getTransaction().commit();
			return a;
		} finally {
			em.close();
		}
	}
	public void delete(ElementoCatalogo a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public void update(ElementoCatalogo a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public List<ElementoCatalogo> findAll(){
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createNamedQuery("ElementoCatalogo.findAll");
		try {
			return q.getResultList();
			
		} finally {
			em.close();
		}
	}
	public List<ElementoCatalogo> cercaPerAnno(int anno){
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPublicazione = :annocercato");
		q.setParameter("annocercato", anno);
		try {
			return q.getResultList();
			
		} finally {
			em.close();
		}
	}
	public List<ElementoCatalogo> cercaPerAutore(String autore){
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.autore LIKE :autorecercato");
		q.setParameter("autorecercato", autore);
		try {
			return q.getResultList();
			
		} finally {
			em.close();
		}
	}
	public List<ElementoCatalogo> cercaPerTitolo(String titolo){
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolocercato");
		q.setParameter("titolocercato","%"+titolo+"%");
		try {
			return q.getResultList();
			
		} finally {
			em.close();
		}
	}
}
