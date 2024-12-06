package in.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
