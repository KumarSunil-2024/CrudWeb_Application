package in.crud.service;

import java.util.List;

import in.crud.dto.EmployeeDTO;

public interface EmployeeService {
EmployeeDTO createEmployee(EmployeeDTO employeeDto);

EmployeeDTO getEmployeeById(Long employeeId);

List<EmployeeDTO> getAllEmployees();

EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);

void deleteEmployee(Long employeeId);
}
