package org.tctalent.anonymization.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * Jackson can't deserialize PageImpl.
 * <p/>
 * From <a href="https://stackoverflow.com/a/71515470/929968">Stackoverflow</a>
 *
 * @author John Camaron
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"pageable"})
public class RestPage<T> extends PageImpl<T> {

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public RestPage(@JsonProperty("content") List<T> content,
      @JsonProperty("number") int page,
      @JsonProperty("size") int size,
      @JsonProperty("totalElements") long total) {

    //TODO JC Hard code size because not currently being returned by TC server. See DtoBuilder.buildPage
    super(content, PageRequest.of(page, 100), total);
  }

  public RestPage(Page<T> page) {
    super(page.getContent(), page.getPageable(), page.getTotalElements());
  }
}
