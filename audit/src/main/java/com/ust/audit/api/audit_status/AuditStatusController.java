package com.ust.audit.api.audit_status;

import com.ust.audit.api.benchmark.BenchMarkEntity;
import com.ust.audit.api.checklist.CheckListEntity;
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


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/auditstatus")
    public ResponseEntity<AuditStatusEntity> add(@RequestBody AuditStatusEntity auditStatusEntity) {
        try {
            auditStatusEntity.setAuditStatus(auditStatusService.checkBeckmark(auditStatusEntity));
            auditStatusService.saveAuditStatus(auditStatusEntity);
            return new ResponseEntity<AuditStatusEntity>(auditStatusEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<AuditStatusEntity>(HttpStatus.PRECONDITION_FAILED);
        }

    }

     //----------------------------------------------------------

    /*
     @PostMapping("/auditstatusarespose")
     public ResponseEntity<List<AuditStatusEntity>>  add(@RequestBody List<AuditStatusEntity> auditStatusEntity){
         auditStatusService.saveAuditStatusList(auditStatusEntity);
         return new ResponseEntity<List<AuditStatusEntity>>(auditStatusEntity,HttpStatus.OK);
     }

     */

     //----------------------------------------------------------

    @GetMapping("/auditstatus/{id}")
    public ResponseEntity<AuditStatusEntity> get(@PathVariable Integer id){
        try{
            AuditStatusEntity auditStatusEntity=auditStatusService.getAuditStatusID(id);
            return  new ResponseEntity<AuditStatusEntity>(auditStatusEntity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<AuditStatusEntity>(HttpStatus.NOT_FOUND);
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/auditstatus")
    public ResponseEntity<List<AuditStatusEntityDto>> getAll(){
        try{
            List<AuditStatusEntity> getAuditStatusAllList = auditStatusService.getAuditStatusAll();
            List<AuditStatusEntityDto> auditStatusEntityDto = auditStatusService.entityToDtoConverter(getAuditStatusAllList);
            return new ResponseEntity<List<AuditStatusEntityDto>>(auditStatusEntityDto, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List<AuditStatusEntityDto>>(HttpStatus.NOT_FOUND);
        }
    }




}
