package com.ust.audit.api.checklist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Check list repository.
 */
@Repository
public interface CheckListRepository extends JpaRepository<CheckListEntity, Integer> {

    /**
     * Gets questions by audit type.
     *
     * @param type the type
     * @return the questions by audit type
     */
    @Query(value = "SELECT q FROM CheckListEntity  q WHERE q.auditChecklistAuditType=?1")
    List<CheckListEntity> getQuestionsByAuditType(String type);


    /*
    @Query(value = "SELECT * FROM ust_audit_checklist u  WHERE u.audit_checklist_audit_type=?1" ,nativeQuery = true)
    List<CheckListEntity> getQuestionsByAuditType(String type);
     */
}
