package com.ust.audit.api.audit_status;

import com.ust.audit.api.benchmark.BenchMarkEntity;
import com.ust.audit.api.checklist.CheckListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditStatusRepository extends JpaRepository <AuditStatusEntity,Integer>{

    @Query(value = "SELECT q.auditBenchmarkMinNum FROM BenchMarkEntity  q WHERE q.auditBenchmarkAuditType=?1")
    int findBenchmarkByType(String type);

    /**
    @Query(value = "SELECT q FROM BenchMarkEntity q order by q.auditStatusId ")
    List<AuditStatusEntity> findAllAuditStatus();
*/


}
