package Datas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class JExtraxtDataFromUser {

	public static List<JUtilizator> obtinereNumeUseri() {

		List<JUtilizator> numeUseri = new ArrayList<>();

		EntityManager em = JPersistanceManager.INSTANCE.getEntityManager();

		try {
			javax.persistence.TypedQuery<JUtilizator> query = em.createQuery("SELECT u FROM JUtilizator u",
					JUtilizator.class);
			numeUseri = query.getResultList();
		} catch (NoResultException e) {
			System.out.println("Nu sunt useri");
		}

		return numeUseri;
	}

	public static JUtilizator obtinereIDUseri(String user) {

		JUtilizator userul = new JUtilizator();

		EntityManager em = JPersistanceManager.INSTANCE.getEntityManager();

		try {
			javax.persistence.TypedQuery<JUtilizator> query = em
					.createQuery("SELECT u FROM JUtilizator u where NUME_USERI = '" + user + "'", JUtilizator.class);
			userul = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Nu sunt useri");
		}

		return userul;
	}
}
