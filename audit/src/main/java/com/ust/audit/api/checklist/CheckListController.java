package com.ust.audit.api.checklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Check list controller.
 */
@RestController
public class CheckListController {

    /**
     * The Check list service.
     */
    @Autowired
    CheckListService checkListService;

    /**
     * Get response entity.
     *
     * @param type the type
     * @return the response entity
     */

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
    @PostMapping("/checklist")
    public ResponseEntity<CheckListEntity> add(@RequestBody CheckListEntity checkListEntity){
        try{
            checkListService.saveCheckList(checkListEntity);
            return new ResponseEntity<CheckListEntity>(checkListEntity,HttpStatus.OK);

        }
        catch(NoSuchElementException e){
            return new ResponseEntity<CheckListEntity>(HttpStatus.NOT_FOUND);

        }
    }


}
