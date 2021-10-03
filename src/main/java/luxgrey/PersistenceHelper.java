package luxgrey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHelper {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

  public static EntityManager createEntityManager() {
    return emf.createEntityManager();
  }
}
