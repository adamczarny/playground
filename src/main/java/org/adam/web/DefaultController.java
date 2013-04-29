package org.adam.web;

import org.adam.domain.Pet;
import org.adam.domain.User;
import org.adam.service.PetService;
import org.adam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class DefaultController {
  private UserService userService;
  @Autowired
  private PetService petService;

  @Autowired
  public void setUserService(UserService service) {
    this.userService = service;
  }

  @ModelAttribute(value = "petForm")
  PetForm getPetForm() {
    return new PetForm();
  }

  @RequestMapping(value = "/welcome")
  @Transactional(readOnly = true)
  public String welcome(@ModelAttribute
                        UserValueObject userValueObject) {
    prepareUVOfrom(userService.getFirstUser(), userValueObject);
    return "welcome";
  }

  @RequestMapping(value = "/getUsers")
  @ResponseBody
  @Transactional(readOnly = true)
  public List<String> getUserNames() {
    List<String> names = userService.getUserNames();
    return names;
  }

  @RequestMapping(value = "/getPet")
  @ResponseBody
  public Map<String, ? extends Object> gePet(@RequestParam
                                             int id) {
    System.out.println("requested");

    User user = userService.getFirstUser();
    return Collections.singletonMap("pets", preparePVOfrom(user));
  }

  @RequestMapping(value = "/addPet", method = RequestMethod.POST)
  @ResponseBody
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public ValidationResponse update(@ModelAttribute("petForm")
                                   @Valid
                                   PetForm form, BindingResult result) {
    ValidationResponse validationResponse = new ValidationResponse();
    if (result.hasErrors()) {
      validationResponse.setStatus("FAILURE");
      for (FieldError error : result.getFieldErrors()) {
        validationResponse.getErrorMessageList().put(error.getField(), error.getDefaultMessage());
      }
    } else {
      validationResponse.setStatus("SUCCESS");
      petService.addPet(form.getName(), form.getOwner());
    }
    return validationResponse;
  }


  private void prepareUVOfrom(User u, UserValueObject UVO) {
    System.out.println("start");
    UVO.setName(u.getVorname() + " " + u.getSurname());
    UVO.setId(u.getId());

    List<String> petNames = new ArrayList<String>();
    for (Pet pet : u.getPets()) {
      petNames.add(pet.getPetName());
    }
    UVO.setPetNames(petNames);
    System.out.println("end");
  }

  private List<PetValueObject> preparePVOfrom(User u) {
    List<PetValueObject> pets = new ArrayList<PetValueObject>();
    for (Pet p : u.getPets()) {
      pets.add(new PetValueObject(p.getPetName()));
    }
    return pets;
  }
}
