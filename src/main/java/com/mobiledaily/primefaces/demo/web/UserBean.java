package com.mobiledaily.primefaces.demo.web;

import com.mobiledaily.primefaces.demo.service.UserService;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Johnson
 * Date: 1/25/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 5029403506713131258L;
    @ManagedProperty(value = "#{userService}")
    private UserService userService;
    private String message;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/notifications", new FacesMessage("info", message));
        pushContext.push("/notifications", new FacesMessage("Johnson He", "Hello world"));
    }

    public void save(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Hello "));
        context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));
    }
}
