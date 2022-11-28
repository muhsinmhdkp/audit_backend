package com.ust.audit.api.checklist;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Check list entity.
 */
@Entity
@Data
@Table(name = "ust_audit_checklist")
public class CheckListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ustAuditChecklistId ;

    @Column(name="ust_audit_checklist_audit_type",nullable = false)
    private String checklistAuditType;

    @Column(name="ust_audit_checklist_questions",nullable = false)
    private String checklistQuestions;

    @Column(name="ust_audit_checklist_status",nullable = false)
    private boolean checklistStatus;

    @Column(name="ust_audit_checklist_created_date",nullable = false)
    private LocalDateTime checklistCreatedDate;

    @Column(name="ust_audit_checklist_modified_date")
    private LocalDateTime checklistModifiedDate;
}
