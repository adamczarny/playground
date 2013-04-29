package org.adam.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 4/15/13
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PetDaoImpl extends HibernateDaoSupport implements PetDao {
  @Autowired
  public void settSessionFatory(SessionFactory factory) {
    this.setSessionFactory(factory);
  }

  @Override
  public void addPet(Integer userId, String petName) {
    Pet newPet = new Pet();
    newPet.setPetName(petName);
    newPet.setUserId(userId);
    this.getSessionFactory().getCurrentSession().persist(newPet);
  }
}
