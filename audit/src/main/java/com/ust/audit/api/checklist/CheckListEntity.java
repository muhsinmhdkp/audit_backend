package com.ust.audit.api.checklist;

import com.ust.audit.api.audit_status.AuditStatusEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ust_audit_checklist")
public class CheckListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ust_audit_checklist_id")
    private int auditChecklistId ;

    @Column(name = "ust_audit_checklist_type", nullable = false)
    private String auditChecklistType;

    @Column(name = "ust_audit_checklist_questions",nullable = false)
    private String auditChecklistQuestions;

    @Column(name = "ust_audit_checklist_status",nullable = false)
    private boolean auditChecklistStatus;

    @Column(name = "ust_audit_checklist_created_date",nullable = false)
    private LocalDateTime auditChecklistCreatedDate;

    @Column(name = "ust_audit_checklist_modified_date")
    private LocalDateTime auditChecklistModifiedDate;

    @OneToOne(mappedBy="checkListId")
    private AuditStatusEntity auditStatusEntity;
}
