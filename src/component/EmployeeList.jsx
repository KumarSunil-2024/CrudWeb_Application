import React, { useEffect, useState } from 'react';
import { listEmployee } from '../services/EmployeeService';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    // Fetch employee data on component mount
    listEmployee()
      .then((response) => {
        setEmployees(response.data); // Assuming response.data contains employee data
      })
      .catch((error) => {
        console.error('Error fetching employees:', error);
      });
  }, []); // Empty dependency array ensures it runs once when the component mounts

  return (
    <div className="container">
      <h2>Employee List</h2>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}> {/* Assuming employee has an 'id' */}
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeList;
