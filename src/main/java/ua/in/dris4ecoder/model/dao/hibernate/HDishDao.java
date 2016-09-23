package ua.in.dris4ecoder.model.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.model.businessObjects.Dish;
import ua.in.dris4ecoder.model.dao.DishDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:17.
 */
@SuppressWarnings("JpaQlInspection")
public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        final Session session = sessionFactory.getCurrentSession();
        Query<Dish> query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return query.uniqueResult();
    }

    @Override
    @Transactional
    public void removeAll() {
        final Query query = sessionFactory.getCurrentSession().createQuery("delete from ua.in.dris4ecoder.model.businessObjects.Dish");
        query.executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
