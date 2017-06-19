package Datas;

import javax.persistence.EntityManager;

public class JInsertInUser {

	public static void insertUser(String user) {

		JUtilizator u = new JUtilizator(0, user);

		EntityManager em = JPersistanceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
}
