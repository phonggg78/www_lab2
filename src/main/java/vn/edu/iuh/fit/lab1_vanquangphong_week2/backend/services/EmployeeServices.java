package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.services;

import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Employee;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;

    public EmployeeServices() {
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        employeeRepository.insertEmp(employee);
    }

    public void updateEmp(Employee employee) {
        employeeRepository.updateEmp(employee);
    }

    public boolean deleteEmp(long id) {
        Employee e = employeeRepository.findById(id);

        return employeeRepository.deleteEmp(e);
    }

    public Employee findById(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }
}
