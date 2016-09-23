package ua.in.dris4ecoder.services;

import org.springframework.beans.factory.annotation.Autowired;
import ua.in.dris4ecoder.controllers.dbControllers.EmployeeController;
import ua.in.dris4ecoder.model.businessObjects.Waiter;

import java.util.List;

/**
 * Created by Alex Korneyko on 22.09.2016 18:57.
 */
public class EmployeeService {

    private EmployeeController employeeController;

    public List<Waiter> getEmployees() {

        return employeeController.getAllEmployees();
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
