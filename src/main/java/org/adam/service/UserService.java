package org.adam.service;

import org.adam.domain.User;
import org.adam.domain.UserDao;
import org.adam.web.UserValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {
  @Autowired
  private UserDao dao;


  public void setUserDao(UserDao dao) {
    this.dao = dao;
  }

  public User getFirstUser() {
    return dao.findById(1);
  }

  public List<String> getUserNames() {
    return dao.getUserNames();
  }

  public void addUser(UserValueObject valueObject) {
    //TODO
  }
}
