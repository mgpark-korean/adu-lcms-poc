package com.unicon.modulith.question.domain;

import com.unicon.modulith.question.domain.value.QuestionContentValue;
import com.unicon.modulith.question.service.model.Question;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

/**
 * <p> 클래스 설명 </p>
 *
 * @author Mingi Park
 * @version 1.0
 * @since 1.0
 */
@Getter
@Entity
@Table(name = "question")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private QuestionContentValue content;

  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<ResourceLinkEntity> resourceLinks = new ArrayList<>();

  private QuestionEntity(QuestionContentValue content) {
    this.content = content;
    this.resourceLinks = new ArrayList<>();
  }

  public static QuestionEntity create(Question question) {
    QuestionEntity entity = new QuestionEntity(QuestionContentValue.create(question.content()));
    entity.addResourceLinks(question);
    return entity;
  }

  private void addResourceLinks(Question question) {
    if (!CollectionUtils.isEmpty(this.resourceLinks)) {
      this.getResourceLinks().clear();
    }

    if (!CollectionUtils.isEmpty(question.resourceLinks())) {
      this.resourceLinks.addAll(question.resourceLinks().stream()
          .map(resourceLink ->
              ResourceLinkEntity.create(this, resourceLink.resourceId()))
          .toList());
    }
  }

  public void update(Question question) {
    this.content.update(question.content());
    this.addResourceLinks(question);
  }
}