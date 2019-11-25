package hibernatedemo;

import java.util.List;
import org.hibernate.Session;
import pojos.City;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class HibernateDemo {

    public static void main(String[] args) {

        Session session
                = hibernate.HibernateUtil.getSessionFactory().openSession();

        List<City> cities = session.createQuery("FROM City").list();

        session.close();

        cities.forEach((city) -> {
            System.out.println(city.getName());
        });

        hibernate.HibernateUtil.getSessionFactory().close();

    }

}
