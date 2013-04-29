package org.adam.service;

import org.adam.domain.PetDao;
import org.adam.domain.User;
import org.adam.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 4/15/13
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PetService {
  @Autowired
  private PetDao petDao;

  @Autowired
  private UserDao userDao;

  public void addPet(String name, String userName) {
    String[] splittedName = userName.split(" ");
    User user = userDao.findByName(splittedName[1], splittedName[0]);
    if (user != null) {
      petDao.addPet(user.getId(), name);
    }
  }
}
