package ua.in.dris4ecoder.model.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.model.businessObjects.Order;
import ua.in.dris4ecoder.model.dao.OrderDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:18.
 */
@SuppressWarnings("JpaQlInspection")
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from ua.in.dris4ecoder.model.businessObjects.Order o").list();
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from ua.in.dris4ecoder.model.businessObjects.Order").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
