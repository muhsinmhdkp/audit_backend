package com.ust.audit.api.audit_status;

import com.ust.audit.api.benchmark.BenchMarkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AuditStatusController {
    @Autowired
    AuditStatusService auditStatusService;

    @PostMapping("/auditstatus")
    public ResponseEntity<AuditStatusEntity> add(@RequestBody AuditStatusEntity auditStatusEntity) {
        try {
            auditStatusService.saveAuditStatus(auditStatusEntity);
            return new ResponseEntity<AuditStatusEntity>(auditStatusEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<AuditStatusEntity>(HttpStatus.PRECONDITION_FAILED);
        }

    }
    @GetMapping("/auditstatus/{id}")
    public ResponseEntity<AuditStatusEntity> get(@PathVariable Integer id){
        try{
            AuditStatusEntity auditStatusEntity=auditStatusService.getAuditStatusID(id);
            return  new ResponseEntity<AuditStatusEntity>(auditStatusEntity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<AuditStatusEntity>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/auditstatus")
    public ResponseEntity<List<AuditStatusEntity>> getAll(){
        try{
            List<AuditStatusEntity> getAuditStatusAllList = auditStatusService.getAuditStatusAll();
            return new ResponseEntity<List<AuditStatusEntity>>(getAuditStatusAllList, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List<AuditStatusEntity>>(HttpStatus.NOT_FOUND);
        }
    }




}
