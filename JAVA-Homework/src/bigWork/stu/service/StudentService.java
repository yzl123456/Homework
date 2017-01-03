package bigWork.stu.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigWork.stu.entity.Student;
import bigWork.stu.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAll(){
		return studentRepository.getAll();
	}
	public Student getStudentByStuId(String string){
		return studentRepository.getByStuId(string);
	}
	public void saveAndFlush(Student stu){
		studentRepository.saveAndFlush(stu);
	}
	public void delete(Integer id){
		studentRepository.delete(id);
	}
	public Student getById(Integer id){
		return studentRepository.getById(id);
	}
}
