package org.adam.domain;

/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 4/15/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */

public interface PetDao {
  void addPet(Integer userId, String petName);
}
