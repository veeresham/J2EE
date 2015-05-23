package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/StudentList")
public class StudentList extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    DAO dao = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList()
    {
        super();
        dao = new DAO();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");
        out.println("<body>");

        List<Student> list = null;
        try
        {
            list = dao.getList();
            out.println("<H2>List of Sutndets</H2>");

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        if (list == null)
        {
            out.println("Student detailed couldn't be fetched."
                    + " <a href=\"index.html\"> Go to Home Page </a>");
        } else
        {
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Student ID");
            out.println("</th>");
            out.println("<th>");
            out.println("Name");
            out.println("</th>");
            out.println("<th>");
            out.println("Age");
            out.println("</th>");
            out.println("<th>");
            out.println("Gender");
            out.println("</th>");
            out.println("</tr>");
            for (Student s : list)
            {
                out.println("<tr>");
                out.println("<td>");
                out.println(s.getId());
                out.println("</td>");
                out.println("<td>");
                out.println(s.getName());
                out.println("</td>");
                out.println("<td>");
                out.println(s.getAge());
                out.println("</td>");
                out.println("<td>");
                out.println(s.getGender());
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        }

        out.println("</body>");
        out.println("</html>");
    }

}
