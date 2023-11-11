package pro.sky.java.course2.weblibrary.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.weblibrary.model.Employee;
import pro.sky.java.course2.weblibrary.service.EmployeeServiceImpl;
import java.util.Map;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String lastName,
                        @RequestParam String firstName,
                        @RequestParam int department,
                        @RequestParam int salary) {
        return employeeService.addEmployee(lastName, firstName, department, salary);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String lastName,
                           @RequestParam String firstName,
                           @RequestParam int department,
                           @RequestParam int salary) {
        return employeeService.removeEmployee(lastName, firstName, department, salary);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String lastName,
                         @RequestParam String firstName,
                         @RequestParam int department,
                         @RequestParam int salary) {
        return employeeService.findEmployee(lastName, firstName, department, salary);
    }
    @GetMapping()
    public Map allEmployees() {
        return (Map) employeeService.all();
    }
}