package org.adam.web;

/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/27/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class PetValueObject {
  public PetValueObject(String name) {
    this.name = name;
  }

  private String name;

  public String getName() {
    return name;
  }

}
