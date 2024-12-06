package in.crud.service;

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
	

}
