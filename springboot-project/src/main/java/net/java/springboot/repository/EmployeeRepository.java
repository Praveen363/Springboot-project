package net.java.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	/*Page<User> saveAll(String email);


	List<User> saveAll(SortOrder ascending, String email);

	/*User findAllOrderByemailAsc(String email);*/

}

