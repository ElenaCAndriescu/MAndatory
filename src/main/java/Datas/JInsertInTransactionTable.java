package Datas;

import static Datas.JExtraxtDataFromUser.obtinereIDUseri;

import java.util.Date;

import javax.persistence.EntityManager;

public class JInsertInTransactionTable {

	public static void insertUser(String user, int suma, String titlu, Date data, Boolean recurent, String tip,
			String categorie) {

		JUtilizator usere = obtinereIDUseri(user);

		int month = data.getMonth();

		if (recurent == true) {
			for (int i = month; i < 12; i++) {
				data.setMonth(i);
				JTranzactie t = new JTranzactie(0, usere, suma, titlu, recurent, tip, categorie, data);
				EntityManager em = JPersistanceManager.INSTANCE.getEntityManager();
				em.getTransaction().begin();
				em.persist(t);
				em.getTransaction().commit();
			}
		} else {
			JTranzactie t = new JTranzactie(0, usere, suma, titlu, recurent, tip, categorie, data);

			EntityManager em = JPersistanceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		}
	}

}
