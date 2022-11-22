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

    @Column(nullable = false)
    private String ustAuditChecklistAuditType;

    @Column(nullable = false)
    private String ustAuditChecklist0Questions;

    @Column(nullable = false)
    private boolean ustAuditChecklistStatus;

    @Column(nullable = false)
    private LocalDateTime ustAuditChecklistCreatedDate;
    private LocalDateTime ustAuditChecklistModifiedDate;
}
