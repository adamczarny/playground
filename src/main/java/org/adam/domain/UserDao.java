package org.adam.domain;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
  @Transactional(readOnly = true)
  User findById(Integer id);

  User findByName(String surname, String vormane);


  List<String> getUserNames();

  void saveUser(User u);
}
