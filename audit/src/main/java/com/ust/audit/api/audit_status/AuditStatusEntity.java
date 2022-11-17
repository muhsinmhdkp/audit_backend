package com.ust.audit.api.audit_status;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ust_project_auditing_acceptance_status")
public class AuditStatusEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int ustProjectAuditingAcceptanceStatusId;

    @Column(nullable = false, unique = true)
    private int ustProjectAuditingAcceptanceStatusProjectId;

    @Column(nullable = false,unique = true)
    private String ustProjectAuditingAcceptanceStatusProjectName;

    @Column(nullable = false)
    private String ustProjectAuditingAcceptanceStatusInternalStatus;

    @Column(nullable = false)
    private String ustProjectAuditingAcceptanceStatusSoxStatus;

    @Column(nullable = false)
    private boolean ustProjectAuditingAcceptanceStatusStatus;

    @Column(nullable = false)
    private LocalDateTime ustProjectAuditingAcceptanceStatusCreatedDate;
    private LocalDateTime ustProjectAuditingAcceptanceStatusDate;



}
