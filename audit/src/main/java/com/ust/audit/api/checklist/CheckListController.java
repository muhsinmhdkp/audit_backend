package com.ust.audit.api.checklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Check list controller.
 */
@RestController
public class CheckListController {

    /**
     * The Checklist service.
     */
    @Autowired
    CheckListService checkListService;

    /**
     * Get response entity.
     *
     * @param type the type
     * @return the response entity
     */
    @CrossOrigin(origins = "http://localhost:4200/checklist")
    @GetMapping("/checklist/{type}")
    public ResponseEntity<List<QuestionsDto>> get(@PathVariable String type){
        try{
            List<QuestionsDto> questions = checkListService.getQuestionsByAuditType(type);
            return new ResponseEntity<List<QuestionsDto>>(questions, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<QuestionsDto>>(HttpStatus.NOT_FOUND);
        }
    }
}
