package com.cpms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpms.pojos.Course;
import com.cpms.pojos.Project;
import com.cpms.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService implements IProjectService {

	@Autowired 
	ProjectRepository repository;
	
	@Override
	public Project registerProject(Project project) {
		return repository.save(project);
	}

	@Override
	public List<Project> getAllProjectList(Course course) {
		return repository.findAllByOrderById(course);
	}

	@Override
	public List<Project> getProjectsWithNoGuide(/*Course courseName*/) {
		return repository.findAllByGuideIsNull();
	}

}
