package bigWork.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigWork.stu.entity.Student;
import bigWork.user.entity.User;
import bigWork.user.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public User getUserByNameAndPassword(String username,String password){
		User user = userRepository.findByUsernameAndPassword(username, password);
		return user;
	}
	public void saveAndFlush(User user){
		userRepository.saveAndFlush(user);
	}

}
