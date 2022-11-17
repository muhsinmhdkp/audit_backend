package com.ust.audit.api.benchmark;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ust_audit_benchmark_acceptance")
public class BenchMarkEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ustAuditBenchmarkAcceptanceId;

    @Id
    private String ustAuditBenchmarkAcceptanceType;

    private int ustAuditBenchmarkAcceptanceMinNum;

    @Column(nullable = false)
    private boolean ustAuditBenchmarkAcceptanceStatus;

    @Column(nullable = false)
    private LocalDateTime ustAuditBenchmarkAcceptanceCreatedDate;
    private LocalDateTime ustAuditBenchmarkAcceptanceModifiedDate;
}
