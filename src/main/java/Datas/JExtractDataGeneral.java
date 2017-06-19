package Datas;

import static java.util.Calendar.getInstance;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class JExtractDataGeneral {

	public static List<JTranzactie> obtinereTranzactii(String user, String tip) throws SQLException {

		JUtilizator infoRelevant = JExtraxtDataFromUser.obtinereIDUseri(user);
		int id = infoRelevant.getId();

		List<JTranzactie> listaTr = new ArrayList<>();

		EntityManager em = JPersistanceManager.INSTANCE.getEntityManager();

		try {
			javax.persistence.TypedQuery<JTranzactie> query = em.createQuery(
					"SELECT u FROM JTranzactie u WHERE UTILIZATOR_ID = '" + id + "' AND CATEGORIE = '" + tip + "'",
					JTranzactie.class);
			listaTr = query.getResultList();
		} catch (NoResultException e) {
			System.out.println("Nu sunt tranzactii");
		}

		return listaTr;
	}

	public static List<JTranzactie> obtinereTranzactiiCurente(List<JTranzactie> lista) throws SQLException {

		int monthA = getInstance().get(Calendar.MONTH) + 1;

		List<JTranzactie> trnzCurente = new ArrayList<>();

		for (JTranzactie x : lista) {

			Date dataTr = x.getData();
			int lunaTr = dataTr.getMonth();

			if (monthA == lunaTr) {
				trnzCurente.add(x);
			}
		}
		return trnzCurente;
	}

	public static int obtinereValoare(String user, String tip) throws IOException, SQLException {

		List<JTranzactie> date = obtinereTranzactii(user, tip);
		List<JTranzactie> dateCurente = obtinereTranzactiiCurente(date);

		int sumaTotala = 0;

		for (JTranzactie x : dateCurente) {
			sumaTotala += x.getSuma();
		}
		return sumaTotala;
	}
}
