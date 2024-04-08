package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	// derivedquery
	List<Employee> findByDepartment(String department);
//	List<Employee> findByAddressCity(String city);
	
//	use custom queries for this
//	List<Employee> findByAddressCityAndDepartment(String city, String department);
	
//	select * from employee e inner join address a on e.address_id=a.address_id where city=?1
//	and department=?2;
	
	@Query("from Employee e inner join e.address a where a.city=?1 and e.department=?2")
	List<Employee> findByCityDep(String city,String department);
	
	@Query("from Employee e inner join e.address a where a.city=?1")
	List<Employee> findByCity(String city);
	
}
 