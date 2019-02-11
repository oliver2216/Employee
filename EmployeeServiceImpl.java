package EmployeeService;

import java.util.ArrayList;

import com.sagar.Beans.Address;
import com.sagar.Beans.Employee;

import EmployeeRepo.EmployeeRepoImpl;
import Exceptions.EmployeeAlreadyExistException;
import Exceptions.EmployeeDoesNotExistException;
import Exceptions.IdCannotBeNegativeException;
import Exceptions.InvalidAddressException;
import Exceptions.NameNullException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepoImpl emprepoimpl;
	
	
	public EmployeeServiceImpl(EmployeeRepoImpl emprepoimpl) {
		super();
		this.emprepoimpl = emprepoimpl;
	}

	@Override
	public boolean createEmployee(int eid, String name, Address address) throws EmployeeAlreadyExistException, NameNullException, IdCannotBeNegativeException, InvalidAddressException {
	
		if(emprepoimpl.checkForExistence(eid)) {
			throw new EmployeeAlreadyExistException();
		}
		else {
			if(name==null||name.equals("")){
				throw new NameNullException();				
			}
			else if(eid<0) {
				throw new IdCannotBeNegativeException();
				
			}
			else if(address.getAddress()==null||address.getAddress().equals("")||address.getCountry().getCountryNmae()==null||address.getCountry().getCountryNmae().equals("")||address.getCountry().getCity()==null||address.getCountry().getCity().getCityName().equals("")) {
				
				throw new InvalidAddressException();
			}
			else {
				Employee emp= new Employee();
				emp.setEmpid(eid);
				emp.setEmpName(name);
				emp.setAddress(address);
				emprepoimpl.save(emp.getEmpid(),emp);
				return true;
			}
		}
	}

	@Override
	public ArrayList<Employee> searchByName(String name) throws NameNullException, EmployeeDoesNotExistException {
		
		if(name==null||name.equals("")){
			throw new NameNullException();				
		}
		ArrayList<Employee> list = new ArrayList<Employee>();
		list=emprepoimpl.findByName(name);
		if(list==null)
			throw new EmployeeDoesNotExistException();
		return list;
	
	}


}
