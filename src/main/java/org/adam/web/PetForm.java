package org.adam.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 3/19/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class PetForm {
  @Size(max = 10, min = 1)
  String name;
  @NotNull
  @Pattern(regexp = "[A-Z]+ [A-Z]+")
  String owner;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}
