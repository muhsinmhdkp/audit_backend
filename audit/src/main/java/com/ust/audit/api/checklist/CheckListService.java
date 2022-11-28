package com.ust.audit.api.checklist;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Check list service.
 */
@Service
public class CheckListService {

    /**
     * The Checklist repository.
     */
    @Autowired
    CheckListRepository checkListRepository;

    /**
     * The Model mapper.
     */
    @Autowired
    ModelMapper modelMapper;


    /**
     * Gets questions by audit type.
     *
     * @param type the type
     * @return the questions by audit type
     */
    public List<QuestionsDto> getQuestionsByAuditType(String type) {
        List<CheckListEntity> questionList = checkListRepository.getQuestionsByAuditType(type);
        List<QuestionsDto> QuestionsList = modelMapper.map(questionList,new TypeToken<List<QuestionsDto>>(){}.getType());


        return QuestionsList;
    }

    public void saveCheckList(CheckListEntity checkListEntity) {
        checkListEntity.setAuditChecklistCreatedDate(LocalDateTime.now());
        checkListEntity.setAuditChecklistModifiedDate(checkListEntity.getAuditChecklistCreatedDate());
        checkListRepository.save(checkListEntity);
    }

    /**
     List<CheckListEntity> filteredQuestionList = questionList.stream()
     .filter(n-> n.getUstAuditChecklistQuestions().startsWith("Have"))
     .collect(Collectors.toList());
     */

    /**
     *
     * @param checkListEntity
     * @return

    public List<CheckListEntity> getQuestionsByAuditType(CheckListEntity checkListEntity){
        List<CheckListEntity> questionslist = checkListRepository.getQuestionsByAuditType(checkListEntity.getUstAuditChecklistQuestions());
        return questionslist;
    }
     */

}
