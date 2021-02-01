package com.cpms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpms.pojos.Course;
import com.cpms.pojos.Project;
import com.cpms.pojos.Student;
import com.cpms.pojos.UserAccount;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select s from Student s join fetch s.userAccount u "
			+ "where u.courseName = :coursename order by s.prn")
	public List<Student> findAllByOrderByPrn(@Param("coursename") Course coursename);

	Student findByUserAccount(UserAccount userAccount);
	
	List<Student> findByProjectIsNull();
	
	public List<Student> findByProject(Project project);
}
