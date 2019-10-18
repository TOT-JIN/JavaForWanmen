package com.dataapplab.springboot.example;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
/**
 * have the filters fire in the right order â€“ we needed to use the @Order annotation.
 * @author joshuaz
 *
 *void doFilter(..) { 
 *   // do stuff before servlet gets called
 *
 *  // invoke the servlet, or any other filters mapped to the target servlet
 *   chain.doFilter(..);
 *
 *   // do stuff after the servlet finishes
 * }
 */

//@Component
//@Order(2)
public class MyGlobalFilter implements Filter {
  private static final Logger LOGGER = LoggerFactory.getLogger(MyGlobalFilter.class);

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    
    //System.out.println("MyFilter doFilter() is invoked.");
	LOGGER.info("~~~MyFilter doFilter() is invoked.~~~");	  
    Enumeration<String> params = req.getParameterNames();
    
    while (params.hasMoreElements()) {
      String param=params.nextElement();
      LOGGER.info("Parameter:"+param+"\tValue:"+req.getParameter(param));
      //System.out.println("Parameter:"+ param +"\tValue:"+req.getParameter(param));
    }
    chain.doFilter(req, res);
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    
  }

  @Override
  public void destroy() {

  }

}