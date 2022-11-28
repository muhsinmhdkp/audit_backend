package com.ust.audit.api.audit_status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditStatusRepository extends JpaRepository <AuditStatusEntity,Integer>{
}
