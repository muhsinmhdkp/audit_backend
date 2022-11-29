package com.ust.audit.api.benchmark;


import com.ust.audit.api.audit_status.AuditStatusEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "ust_audit_benchmark")
public class BenchMarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ust_audit_benchmark_id")
    private int auditBenchmarkId;

    @Column(name = "ust_audit_benchmark_audit_type", nullable = false,unique = true)
    private String auditBenchmarkAuditType;

    @Column(name="ust_audit_benchmark_min_num", nullable = false)
    private int auditBenchmarkMinNum;

    @Column(name = "ust_audit_benchmark_status", nullable = false)
    private boolean auditBenchmarkStatus;

    @Column(name="ust_audit_benchmark_created_date", nullable = false)
    private LocalDateTime auditBenchmarkCreatedDate;

    @Column(name="ust_audit_benchmark_modified_date")
    private LocalDateTime auditBenchmarkModifiedDate;

    /*
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ust_audit_type_id")
    private AuditTypeEntity auditTypeEntity;

     */

    @OneToOne(mappedBy="benchMarkEntity")
    private AuditStatusEntity auditStatusEntity;
}
