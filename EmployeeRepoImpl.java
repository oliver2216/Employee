package EmployeeRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sagar.Beans.Employee;

public class EmployeeRepoImpl implements EmployeeRepo{

	Map<Integer,Employee> map= new HashMap<Integer,Employee>();
	ArrayList<Employee> list = new ArrayList<Employee>();
	
	@Override
	public boolean save(int id,Employee e) {
		
		map.put(id, e);
		
		return true;
	}

	
	@Override
	public ArrayList<Employee> findByName(String name) {
		
		Iterator<Employee> iterator =map.values().iterator();
				while(iterator.hasNext()) {
					Employee emp= iterator.next();
					if(emp.getEmpName()==name) {
						System.out.println("Found");
						list.add(emp);
					}
					
			}
				if(list.size()>0)
					return list;
				return null;

	}


	@Override
	public boolean checkForExistence(int id) {
		Iterator<Employee> iterator =map.values().iterator();
		while(iterator.hasNext()) {
			Employee emp= iterator.next();
			if(emp.getEmpid()==id)
				return true;
	}
		return false;

	}
}
