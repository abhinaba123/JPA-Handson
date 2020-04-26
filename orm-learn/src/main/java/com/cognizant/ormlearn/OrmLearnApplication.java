package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication


public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static StockService stockService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	
	public static void main(String[] args) throws CountryNotFoundException{
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		stockService=context.getBean(StockService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		//testGetAllCountries();
		//testGetCountry();
		//testAddCountry();
		//testUpdateCountry();
		//testDeleteCountry();
		//testFindByNameContaining();
		//testFindByNameStartingWith();
		
		//testFindFBTillSep();
		//testFindGOOGLmore1250();
		//testFindTop3OrderByVolumeDesc();
		//testFindTop3ByCodeOrderByClose();
		
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
				
		//testGetDepartment();
		//testAddSkillToEmployee();
		//testGetAllPermanentEmployees();
		
		//testAverageSalary();
		getAllEmployeesNative();

		LOGGER.info("Inside main");

	}


	private static void getAllEmployeesNative() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		LOGGER.debug("Employees:{}", employees);
		LOGGER.info("End");

	}


	private static void testAverageSalary() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		double avgsal = employeeService.getAvgSalary(2);
		LOGGER.debug("Average Sal:{}", avgsal);
		LOGGER.info("End");
	}


	private static void testGetAllPermanentEmployees() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}


	private static void testAddSkillToEmployee() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employee.setSkillList(skillList);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Skills:{}", employee.getSkillList());
		employeeService.save(employee);
		LOGGER.info("End");
	}


	private static void testGetDepartment() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		Department department = departmentService.get(2);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employees:{}", department.getEmployeeList());
		LOGGER.info("End");
	}


	private static void testUpdateEmployee() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		Employee emp = employeeService.get(1);
		Department dep = departmentService.get(2);
		
		emp.setDepartment(dep);
		employeeService.save(emp);
		LOGGER.debug("Employee:{}", emp);
		LOGGER.debug("Department:{}", emp.getDepartment());
		LOGGER.info("End");
	}


	private static void testAddEmployee() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		Employee employee = new Employee();
		employee.setName("Abhinaba");
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());
		employee.setSalary(10800);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
		
	}


	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
		}


	public static void testFindByNameStartingWith() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameStartingWith("z");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}


	public static void testFindByNameContaining() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameContaining("ou");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}


	public static void testGetAllCountries() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}


	

	public static void testGetCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}
	
	public static void testAddCountry() throws CountryNotFoundException{
		LOGGER.info("Start");
		Country country1 = new Country();
		country1.setCode("AP");
		country1.setName("Abhinaba Poddar");
		countryService.addCountry(country1);
		Country country2 = countryService.findCountryByCode("AP");
		LOGGER.debug("Country:{}", country2);
		LOGGER.info("End");
	}
	
	public static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.updateCountry("AP", "A Poddar");
		LOGGER.info("AP updated");
		Country country = countryService.findCountryByCode("AP");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}
	
	public static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("AP");
		LOGGER.info("AP deleted");
		testGetAllCountries();
		LOGGER.info("End");
	}
	
	public static void testFindFBTillSep()
	{
		LOGGER.info("Start");
		List<Stock> findFBTillSep=stockService.findFBTillSep();
		LOGGER.debug("stocks:{}", findFBTillSep);
		LOGGER.info("End");
	}
	
	public static void testFindGOOGLmore1250()
	{
		LOGGER.info("Start");
		List<Stock> findGOOGLmore1250=stockService.findGOOGLmore1250();
		LOGGER.debug("stocks:{}", findGOOGLmore1250);
		LOGGER.info("End");
	}
	
	public static void testFindTop3OrderByVolumeDesc()
	{
		LOGGER.info("Start");
		List<Stock> findTop3ByVolume=stockService.findTop3ByCodeOrderByVolumeDesc("FB");
		LOGGER.debug("stocks:{}", findTop3ByVolume);
		LOGGER.info("End");
	}
	
	public static void testFindTop3ByCodeOrderByClose()
	{
		LOGGER.info("Start");
		List<Stock> findBottom3ByCode=stockService.findTop3ByCodeOrderByClose("NFLX");
		LOGGER.debug("stocks:{}", findBottom3ByCode);
		LOGGER.info("End");
	}

}
