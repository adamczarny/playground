package org.adam.web;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 3/19/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ValidationResponse {
  private String status;
  private Map<String, String> errorMessageList = new HashMap<String, String>();

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Map<String, String> getErrorMessageList() {
    return this.errorMessageList;
  }

  public void setErrorMessageList(Map<String, String> errorMessageList) {
    this.errorMessageList = errorMessageList;
  }
}
