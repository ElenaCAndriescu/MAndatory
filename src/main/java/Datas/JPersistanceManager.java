package Datas;

import static javax.persistence.Persistence.createEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public enum JPersistanceManager {

	INSTANCE;

	private EntityManagerFactory emFactory;

	private JPersistanceManager() {
		emFactory = createEntityManagerFactory("Hakku");
	}

	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public void close() {
		emFactory.close();
	}
}
