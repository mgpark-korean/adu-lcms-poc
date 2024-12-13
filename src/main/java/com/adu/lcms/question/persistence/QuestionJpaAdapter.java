package com.adu.lcms.question.persistence;

import com.adu.lcms.common.annotation.PersistenceAdapter;
import com.adu.lcms.question.domain.QuestionEntity;
import com.adu.lcms.question.domain.QuestionMapper;
import com.adu.lcms.question.infra.repository.QuestionRepository;
import com.adu.lcms.question.service.model.Question;
import com.adu.lcms.question.service.port.out.QuestionCrudPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class QuestionJpaAdapter implements QuestionCrudPort {

  private final QuestionRepository repository;
  private final QuestionMapper mapper;

  @Override
  public List<Question> getQuestions() {
    List<QuestionEntity> entities = repository.findAll();
    return mapper.mapToModels(entities);
  }

  @Override
  public Question getQuestion(Long id) {
    return mapper.mapToModel(this.findById(id));
  }

  @Override
  public Question createQuestion(Question question) {
    QuestionEntity entity = QuestionEntity.create(question);
    return mapper.mapToModel(repository.save(entity));
  }

  @Override
  public Question updateQuestion(Question question) {
    QuestionEntity entity = this.findById(question.id());
    entity.update(question);
    return mapper.mapToModel(repository.save(entity));
  }

  @Override
  public void deleteQuestion(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteQuestions(List<Long> ids) {
    repository.deleteAllById(ids);
  }

  private QuestionEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found"));
  }
}
