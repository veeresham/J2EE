package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DAO dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        dao = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response); 
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    Student student = new Student();
	    
	    student.setId(Integer.valueOf(request.getParameter("sid")));
	    student.setName(request.getParameter("sname"));
	    student.setGender(request.getParameter("sgender"));
	    String a = request.getParameter("sage");
	    student.setAge(Integer.valueOf(a)); 
	    
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Response</title>");
        out.println("</head>");
        out.println("<body>");
        
	    try
        {
            dao.save(student);
            out.println("Student saved sucessfully. <a href=\"index.html\"> Go Back </a>");
            
        } catch (Exception e)
        {
            out.println("Student couldn't saved "+e.getMessage()+"."
                    + " <a href=\"index.html\"> Go Back </a>");
            
            e.printStackTrace();
        } 
	    
	    
	    out.println("</body>");
	    out.println("</html>");
	    
	}

}
