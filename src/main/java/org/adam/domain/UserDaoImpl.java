package org.adam.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
  @Autowired
  public void settSessionFatory(SessionFactory factory) {
    this.setSessionFactory(factory);
  }

  @Override
  @Transactional(readOnly = true)
  public User findById(Integer id) {
    return (User) this.getSessionFactory().getCurrentSession().createQuery("from User user where user.id=?")
      .setParameter(0, id)
      .uniqueResult();
  }

  @Override
  public User findByName(String surname, String vorname) {
    return (User) this.getSessionFactory().getCurrentSession()
      .createQuery("from User user where user.surname =? and user.vorname=?")
      .setParameter(0, surname)
      .setParameter(1, vorname)
      .list()
      .get(0);
  }


  @Override
  @Transactional(readOnly = false)
  public void saveUser(User u) {
    this.getSessionFactory().getCurrentSession().persist(u);
  }

  @Override
  public List<String> getUserNames() {
    return (List<String>) this.getSessionFactory().getCurrentSession()
      .createQuery("select Vorname||' '||Surname from User")
      .list();
  }

  @Transactional(readOnly = false)
  public void changePetNames(int userID) {
    User u = this.findById(userID);
    for (Pet p : u.getPets()) {
      p.setPetName(p.getPetName() + u.getAdress());
    }

  }
}
