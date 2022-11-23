package com.ust.audit.api.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    public void saveProjectAudit(ProjectEntity projectEntity) {
        projectEntity.setProjectCreatedDate(LocalDateTime.now());
        projectEntity.setProjectModifiedDate(projectEntity.getProjectCreatedDate());
        projectRepository.save(projectEntity);
    }

    public ProjectEntity getProjectById(Integer id) throws NoSuchElementException {
        return projectRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    public List<ProjectEntity> getAllProject() {
        return projectRepository.findAll();
    }
}
