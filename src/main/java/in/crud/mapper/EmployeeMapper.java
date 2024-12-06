package in.crud.mapper;

import in.crud.dto.EmployeeDTO;
import in.crud.entity.Employee;

public class EmployeeMapper {

    // Mapping Employee entity to EmployeeDTO
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
          employee.getId(),
          employee.getFirstName(),
          employee.getLastName(),
          employee.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDTO employeeDto) {
        return new Employee(
          employeeDto.getId(),
          employeeDto.getFirstName(),
          employeeDto.getLastName(),
          employeeDto.getEmail()
        );
    }
}
