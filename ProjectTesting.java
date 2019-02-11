package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sagar.Beans.Address;
import com.sagar.Beans.City;
import com.sagar.Beans.Country;

import EmployeeRepo.EmployeeRepoImpl;
import EmployeeService.EmployeeServiceImpl;
import Exceptions.EmployeeAlreadyExistException;
import Exceptions.EmployeeDoesNotExistException;
import Exceptions.IdCannotBeNegativeException;
import Exceptions.InvalidAddressException;
import Exceptions.NameNullException;

public class ProjectTesting {

	EmployeeRepoImpl emprepoimpl = new EmployeeRepoImpl();
	EmployeeServiceImpl empserimpl= new EmployeeServiceImpl(emprepoimpl);
	
	Address ad= new Address();
	Country country= new Country();
	City city = new City();
	@Before
	public void setUp() throws Exception {
		
		
		ad.setAddress("383");
		ad.setCountry(country);
		country.setCountryNmae("India");
		country.setCity(city);
		city.setCityName("Allahabad");
	}

	@Test(expected=Exceptions.NameNullException.class)
	public void whenNullIsPassedAsNameToCreateEmployee() throws NameNullException, EmployeeAlreadyExistException, IdCannotBeNegativeException, InvalidAddressException {
		
		empserimpl.createEmployee(0, null, null);
		
	}
	
	@Test(expected=Exceptions.IdCannotBeNegativeException.class)
	public void whenNegativeIdIsPassedToCreateEmployee() throws EmployeeAlreadyExistException, NameNullException, IdCannotBeNegativeException, InvalidAddressException {
		
		empserimpl.createEmployee(-10, "Sagar", ad);
		
	}
	
	@Test
	public void whenAllDetailsArePassedCorrectlyToCreateEmployee() throws EmployeeAlreadyExistException, NameNullException, IdCannotBeNegativeException, InvalidAddressException {
		assertEquals(true, empserimpl.createEmployee(101, "Sagar",ad));
	}

	@Test(expected=Exceptions.NameNullException.class)
	public void whenNameIsPassedAsNullToSearchEmployee() throws NameNullException, EmployeeDoesNotExistException {
		empserimpl.searchByName(null);
	}
	
	@Test(expected=Exceptions.EmployeeDoesNotExistException.class)
	public void whenNonExistingEmployeeIsBeingSearched() throws NameNullException, EmployeeDoesNotExistException{
		
		empserimpl.searchByName("Sagarr");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
