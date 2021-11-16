package com.yin4learn.springbootcxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.yin4learn.springbootcxf.model.User;

@WebService(targetNamespace = "http://ws.cxf.yin4learn.org/")
public interface UserService {


    @WebMethod
    public String getUserName(
            /* The input parameter name is userId and the default value is arg0*/
            @WebParam(name = "userId")
                    String userId
    );

    @WebMethod
    public User getUser(

            @WebParam(name = "userId")
                    String userId
    );

    @WebMethod
    public java.util.List<User> getUserList(

            @WebParam(name = "userId")
                    String userId
    );
}