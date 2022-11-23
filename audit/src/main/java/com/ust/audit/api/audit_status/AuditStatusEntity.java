package com.ust.audit.api.audit_status;

import com.ust.audit.api.checklist.CheckListEntity;
import com.ust.audit.api.project.ProjectEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ust_audit_status")
public class AuditStatusEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "ust_audit_status_id")
    private int auditStatusId;

    /*
    @Column(name = "ust_audit_status_project_id",nullable = false, unique = true)
    private int auditStatusProjectId;

    @Column(name = "ust_audit_status_project_name", nullable = false,unique = true)
    private String auditStatusProjectName;

    @Column(name = "ust_audit_status_internal_status",nullable = false)
    private String auditStatusInternalStatus;

    @Column(name = "ust_audit_status_sox_status",nullable = false)
    private String auditStatusSoxStatus;

    @Column(name = "ust_audit_status_status",nullable = false)
    private boolean auditStatusStatus;

    @Column(name = "ust_audit_status_created_date",nullable = false)
    private LocalDateTime auditStatusCreatedDate;

    @Column(name = "ust_audit_status_modified_date")
    private LocalDateTime auditStatusModifiedDate;

    */

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ust_audit_project_id")
    private ProjectEntity projectId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ust_audit_checklist_id")
    private CheckListEntity checkListId;

    @Column(name = "ust_audit_status_response",nullable = false)
    private boolean  auditResponse;

    @Column(name = "ust_audit_status_status",nullable = false)
    private boolean auditStatusStatus;

    @Column(name = "ust_audit_status_created_date",nullable = false)
    private LocalDateTime auditStatusCreatedDate;

    @Column(name = "ust_audit_status_modified_date")
    private LocalDateTime auditStatusModifiedDate;

}
