package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Entity.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
//@Table(indexes = @Index(name = "INDEX_INITIAL", columnList = "initial"))
public class Entity implements Serializable {

  @Id
  private String name;
  private String initial;


}
