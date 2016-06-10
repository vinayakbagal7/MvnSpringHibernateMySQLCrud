package com.howtodoinjava.dao;

import java.util.List;
import com.howtodoinjava.entity.EmployeeEntity;

public interface EmployeeDAO 
{
    public void addEmployee(EmployeeEntity employee);
    public void updateEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
	EmployeeEntity getEmployee(Integer employeeId);
}