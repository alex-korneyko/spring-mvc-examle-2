package ua.in.dris4ecoder.controllers.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.in.dris4ecoder.model.businessObjects.Waiter;
import ua.in.dris4ecoder.services.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * Created by Alex Korneyko on 22.09.2016 18:55.
 */
@Controller
public class EmployeeWebController {

    private EmployeeService employeeService;

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {

        List<Waiter> employees = employeeService.getEmployees();
        model.put("employees", employees);

        return "employees";
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
