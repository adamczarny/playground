package org.adam.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER")
public class User {
  private String surname;
  private String vorname;
  private String adress;
  private Integer id;
  private Set<Pet> pets;

  public String getSurname() {
    return surname;
  }

  @Column(name = "id", unique = true, nullable = false)
  @Id
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Fetch(FetchMode.JOIN)
  @JoinColumn(name = "userId")
  @OneToMany(fetch = FetchType.EAGER)
  public Set<Pet> getPets() {
    return pets;
  }

  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }
}
