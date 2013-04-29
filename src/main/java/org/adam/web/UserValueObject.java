package org.adam.web;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserValueObject {
  private Integer id;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getPetNames() {
    return petNames;
  }

  public void setPetNames(List<String> petNames) {
    this.petNames = petNames;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  List<String> petNames;
}
