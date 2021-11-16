package com.yin4learn.springbootcxf.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yin4learn.springbootcxf.service.UserService;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfServerConfig {

	@Autowired
    private Bus bus;

    @Autowired
    private UserService userService;

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
    }

    @Bean
    public Endpoint userEndpoint() {
        EndpointImpl endpoint =
                new EndpointImpl(bus, userService);
        endpoint.publish("/user");

        return endpoint;
    }
}
