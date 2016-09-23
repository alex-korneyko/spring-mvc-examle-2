package ua.in.dris4ecoder.springConfigs;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.in.dris4ecoder.Main;
import ua.in.dris4ecoder.controllers.dbControllers.DishController;
import ua.in.dris4ecoder.controllers.dbControllers.EmployeeController;
import ua.in.dris4ecoder.controllers.dbControllers.OrderController;
import ua.in.dris4ecoder.controllers.webControllers.EmployeeWebController;
import ua.in.dris4ecoder.controllers.webControllers.MainController;
import ua.in.dris4ecoder.model.dao.DishDao;
import ua.in.dris4ecoder.model.dao.EmployeeDao;
import ua.in.dris4ecoder.model.dao.OrderDao;
import ua.in.dris4ecoder.model.dao.hibernate.HDishDao;
import ua.in.dris4ecoder.model.dao.hibernate.HEmployeeDao;
import ua.in.dris4ecoder.model.dao.hibernate.HOrderDao;
import ua.in.dris4ecoder.services.EmployeeService;

/**
 * Created by Alex Korneyko on 13.08.2016 20:47.
 */
@Configuration
public class AppConfig {

    @Bean
    Main mainObject(EmployeeController controller,
                    DishController dishController,
                    OrderController orderController) {
        Main main = new Main();
        main.setEmployeeController(controller);
        main.setDishController(dishController);
        main.setOrderController(orderController);

        main.init(false);

        return main;
    }

    @Bean
    EmployeeController employeeController(EmployeeDao employeeDao) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.setEmployeeDao(employeeDao);
        return employeeController;
    }

    @Bean
    DishController dishController(DishDao dishDao) {
        DishController dishController = new DishController();
        dishController.setDishDao(dishDao);
        return dishController;
    }

    @Bean
    OrderController orderController(EmployeeDao employeeDao, DishDao dishDao, OrderDao orderDao) {
        OrderController controller = new OrderController();
        controller.setDishDao(dishDao);
        controller.setEmployeeDao(employeeDao);
        controller.setOrderDao(orderDao);
        return controller;
    }

    @Bean
    EmployeeDao hEmployeeDao(SessionFactory sessionFactoryBean) {
        HEmployeeDao hEmployeeDao = new HEmployeeDao();
        hEmployeeDao.setSessionFactory(sessionFactoryBean);
        return hEmployeeDao;
    }

    @Bean
    DishDao hDishDao(SessionFactory sessionFactory) {
        HDishDao hDishDao = new HDishDao();
        hDishDao.setSessionFactory(sessionFactory);
        return hDishDao;
    }

    @Bean
    OrderDao orderDao(SessionFactory sessionFactory) {
        HOrderDao orderDao = new HOrderDao();
        orderDao.setSessionFactory(sessionFactory);
        return orderDao;
    }

    @Bean
    EmployeeService employeeService(EmployeeController employeeController) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeController(employeeController);
        return employeeService;
    }

    @Bean
    EmployeeWebController employeeWebController(EmployeeService employeeService) {
        EmployeeWebController employeeWebController = new EmployeeWebController();
        employeeWebController.setEmployeeService(employeeService);
        return employeeWebController;
    }
}
