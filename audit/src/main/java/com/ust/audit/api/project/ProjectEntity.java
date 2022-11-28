package com.ust.audit.api.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ust.audit.api.audit_status.AuditStatusEntity;
import com.ust.audit.api.checklist.CheckListEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ust_project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ust_project_id")
    private int projectId;

    @Column(name = "ust_project_name",nullable = false)
    private String projectName;

    @Column(name = "ust_project_manager",nullable = false)
    private String projectManager;

    @Column(name = "ust_project_application_owner",nullable = false)
    private String projectApplicationOwner;

    @Column(name = "ust_project_email_id",nullable = false,unique = true)
    private String projectEmailId;

    @Column(name = "ust_project_status",nullable = false)
    private boolean projectStatus;

    @Column(name = "ust_project_created_date",nullable = false)
    private LocalDateTime projectCreatedDate;

    @Column(name = "ust_project_modified_date")
    private LocalDateTime projectModifiedDate;


    @OneToOne(cascade  =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="projectId")
   // @JsonIgnore
    private AuditStatusEntity auditStatusEntity;

}
