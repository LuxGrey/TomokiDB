package luxgrey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceHelper {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

  public static EntityManager createEntityManager() {
    return emf.createEntityManager();
  }
}
