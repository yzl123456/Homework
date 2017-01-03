package bigWork.user.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bigWork.stu.entity.Student;
import bigWork.user.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("FROM User")
	List<Student> getAll();
	User findByUsernameAndPassword(String username,String password);
	
	
}
