package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import model.Utente;
import utils.JpaUtil;

public class UtenteDao {
	public void salva(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}
	public Utente   getById(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Utente u = em.find(Utente.class, id);
			em.getTransaction().commit();
			return u;
		} finally {
			em.close();
		}
	}
	public void delete(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public void update(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public List<Utente> findAll(){
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createNamedQuery("Utente.findAll");
		try {
			return q.getResultList();
			
		} finally {
			em.close();
		}
	}
}
