package fabriciocarvalho348.com.github.rasfood.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RASF00D = Persistence.createEntityManagerFactory("rasFood");
    public static EntityManager getEntityManagerRasFood() {
        return RASF00D.createEntityManager();
    }
}
