package in.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.crud.dto.EmployeeDTO;
import in.crud.entity.Employee;
import in.crud.exception.ResourceNotFoundException;
import in.crud.mapper.EmployeeMapper;
import in.crud.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
		
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
	Employee employee=employeeRepository.findById(employeeId)
		.orElseThrow(()->
		new ResourceNotFoundException("Employee is Not Exist with given id :"+employeeId));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
	    List<Employee> employees = employeeRepository.findAll();
	    return employees.stream()
	                    .map(EmployeeMapper::mapToEmployeeDTO)  
	                    .collect(Collectors.toList());
	}
	
	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId)
		        .orElseThrow(() -> new RuntimeException("Employee not found with given ID: " + employeeId));
		 employee.setFirstName(updatedEmployee.getFirstName());
		 employee.setLastName(updatedEmployee.getLastName());
		 employee.setEmail(updatedEmployee.getEmail());
		 Employee updatedEmployeeObj = employeeRepository.save(employee);
		 
		 return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
		        .orElseThrow(() -> new RuntimeException("Employee not found with given ID: " + employeeId));
		employeeRepository.deleteById(employeeId);
	}
}
