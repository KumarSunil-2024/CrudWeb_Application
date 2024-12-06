package in.crud.service;

import in.crud.dto.EmployeeDTO;

public interface EmployeeService {
EmployeeDTO createEmployee(EmployeeDTO employeeDto);

EmployeeDTO getEmployeeById(Long employeeId);
}
