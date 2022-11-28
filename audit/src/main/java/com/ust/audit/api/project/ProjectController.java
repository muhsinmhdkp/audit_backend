package com.ust.audit.api.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/project")
    public ResponseEntity<ProjectEntity> add(@RequestBody ProjectEntity projectEntity){
        try{
            projectService.saveProjectAudit(projectEntity);
            return new ResponseEntity<ProjectEntity>(projectEntity, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<ProjectEntity>(HttpStatus.PRECONDITION_FAILED);
        }
    }
    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectEntity> get(@PathVariable Integer id){
        try{
            ProjectEntity projectEntity=projectService.getProjectById(id);
            return  new ResponseEntity<ProjectEntity>(projectEntity,HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<ProjectEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/project")
    public ResponseEntity<List<ProjectEntity>> get(){
        try{
            List<ProjectEntity> projectEntityList=projectService.getAllProject();
            return new ResponseEntity<List<ProjectEntity>>(projectEntityList,HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List<ProjectEntity>>(HttpStatus.NOT_FOUND);
        }
    }


}
