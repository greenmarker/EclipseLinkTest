import org.eclipse.persistence.jpa.PersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Kamil on 2015-12-21.
 */
public class MainTest {

    public static void main(String[] args){
        PersistenceProvider provider = new PersistenceProvider();
        EntityManagerFactory emf = provider.createEntityManagerFactory("sample", null);

        EntityManager em = emf.createEntityManager();
        // DROP TABLE POINT
        // CREATE TABLE POINT (ID BIGINT NOT NULL, X DOUBLE, Y DOUBLE, PRIMARY KEY (ID))
        // DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
        // SELECT * FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
        // INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)


        Point p = new Point(1, 1);
        em.persist(p);
        // UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + ? WHERE SEQ_NAME = ?
        //   bind => [2 parameters bound]
        // SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = ?
        //   bind => [1 parameter bound]
        em.close();


        EntityManager em2 = emf.createEntityManager();
        Query query = em2.createQuery("select p from Point p");
        List list = query.getResultList();
        // SELECT ID, X, Y FROM POINT
        System.out.println("Found objects: " + list.size());
        // Found objects: 0
        for (Object elt: list){
            System.out.println(elt);
        }
    }
}
