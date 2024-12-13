package com.unicon.modulith.question.service.port.in;

import com.unicon.modulith.question.service.model.QuestionRecord;
import java.util.List;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
public interface QuestionManagementUseCase {

  List<QuestionRecord> getQuestions();
}
