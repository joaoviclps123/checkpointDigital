package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.util.EntityManagerFacade;

public class UsuarioDAO {
	EntityManager manager = EntityManagerFacade.getEntityManager();
		
	public void create(Usuario usuario) {
			
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			
			manager.close();
		}

	public List<Usuario> getAll(){
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

}
