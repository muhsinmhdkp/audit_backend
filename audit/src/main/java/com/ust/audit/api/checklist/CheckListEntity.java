package com.ust.audit.api.checklist;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ust_audit_checklist")
public class CheckListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ustAuditChecklistId ;

    @Column(nullable = false)
    private String ustAuditChecklistType;

    @Column(nullable = false)
    private String ustAuditChecklistQuestions;

    @Column(nullable = false)
    private boolean ustAuditChecklistStatus;

    @Column(nullable = false)
    private LocalDateTime ustAuditChecklistCreatedDate;
    private LocalDateTime ustAuditChecklistModifiedDate;
}
