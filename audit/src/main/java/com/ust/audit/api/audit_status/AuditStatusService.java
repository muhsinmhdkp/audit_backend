package com.ust.audit.api.audit_status;

import com.ust.audit.api.benchmark.BenchMarkEntity;
import com.ust.audit.api.benchmark.BenchMarkRepository;
import com.ust.audit.api.checklist.CheckListEntity;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class AuditStatusService {
    @Autowired
    AuditStatusRepository auditStatusRepository;



    public  List<AuditStatusEntity> getAuditStatusAll() {
        return auditStatusRepository.findAll();
    }

    public void saveAuditStatus(AuditStatusEntity auditStatusEntity) {
        auditStatusEntity.setAuditStatusCreatedDate(LocalDateTime.now());
        //auditStatusEntity.setAuditStatusModifiedDate(auditStatusEntity.getAuditStatusCreatedDate());
        auditStatusRepository.save(auditStatusEntity);
    }
    //-------------------------------

    public void saveAuditStatusList(List<AuditStatusEntity> auditStatusEntity) {
        //auditStatusEntity.setAuditStatusCreatedDate(LocalDateTime.now());
        //checkListEntity.setAuditChecklistModifiedDate(checkListEntity.getAuditChecklistCreatedDate());
        auditStatusRepository.saveAll(auditStatusEntity);
    }

    //-------------------------------

    public AuditStatusEntity getAuditStatusID(Integer id) {
        return auditStatusRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    public String checkBeckmark(AuditStatusEntity auditStatusEntity) {

        int benchmarknum = auditStatusRepository.findBenchmarkByType(auditStatusEntity.getAuditType());

        if(auditStatusEntity.getAuditResponseYesCount()>=benchmarknum)  {

            return "success";
        }
        else {
            return "failure";
        }

    }

}
