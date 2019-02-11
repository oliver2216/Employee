package EmployeeRepo;

import java.util.ArrayList;

import com.sagar.Beans.Employee;

public interface EmployeeRepo {

	boolean save(int id,Employee e);
	ArrayList<Employee> findByName(String name);
	boolean checkForExistence(int id);
}
