package com.dataapplab.ecommerce;
/**
 * HttpServlet init() method and destroy() method are called only once in servlet life cycle, 
 * so we don’t need to worry about their synchronization. But service methods such as doGet() or doPost() 
 * are getting called in every client request and since servlet uses multithreading, 
 * we should provide thread safety in these methods.
 * 所以此时如果Servlet1中定义了实例变量或静态变量，那么可能会发生线程安全问题。
 */
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/problem")
public class ProblemServlet extends HttpServlet {

    private String message;  

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        message = request.getParameter("message");  
        try {  
            Thread.sleep(5000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        response.getWriter().write(message);  
	}

}