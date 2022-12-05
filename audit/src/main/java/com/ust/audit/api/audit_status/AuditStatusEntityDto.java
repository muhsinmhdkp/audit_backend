package com.ust.audit.api.audit_status;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class AuditStatusEntityDto {

    private String auditStatus;

    private String auditType;

    private int auditStatusId;

}
