package pro.sky.java.course2.weblibrary.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.weblibrary.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.weblibrary.model.Employee;

import javax.annotation.PostConstruct;
import java.util.*;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private  final List<Employee> employees = new ArrayList<>();
    private Map<String, Employee> employeesMap = new HashMap<>();
    @PostConstruct
    public void name(){
        employees.add(new Employee("андрей","иванов",1, 20000));
        employees.add(new Employee("Игорь","Петров", 2, 25000));
        employees.add(new Employee("Ирина","Сидорова", 1,30000));
    }
    @Override
    public Employee addEmployee(String lastName, String firstName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        employeesMap.putIfAbsent(lastName + " " + firstName, employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String lastName, String firstName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employeesMap.containsValue(employee)) {
            employeesMap.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + employee + " не найден ");
        }
        return employee;
    }
    @Override
    public Employee findEmployee(String lastName, String firstName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employeesMap.containsValue(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + employee + " не найден");
        }
    }
    @Override
    public Map<String, Employee> all() {
        return Map.copyOf(employeesMap);
    }
    @Override
    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}
