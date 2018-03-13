package DatabaseConnectivity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import javax.servlet.*;

public class FilmInsert extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
public FilmInsert() {
    super();
    // TODO Auto-generated constructor stub
}

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse  response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        Dbconnection db=new Dbconnection();
        Connection conn=db.getconnection();

    try{  
      String mov_id = request.getParameter("mov_id");  
      String title = request.getParameter("title");  
      int length = Integer.parseInt(request.getParameter("duration"));  
      String dir_id = request.getParameter("director_id");  
      float rating = Float.parseFloat(request.getParameter("rating"));  

      
      PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into movies(mov_id,title,dir_id,duration,rating) values(?,?,?,?,?)"); 

      pst.setString(1,mov_id);  
      pst.setString(2,title);        
      pst.setString(3,dir_id);
      pst.setInt(4,length);
      pst.setFloat(5,rating);



      int i = pst.executeUpdate();

      String msg=" ";
      if(i!=0){  
        msg="Record has been inserted";
        pw.println("<font size='6' color=blue>" + msg + "</font>");  


      }  
      else{  
        msg="failed to insert the data";
        pw.println("<font size='6' color=blue>" + msg + "</font>");
       }  
      pst.close();
    }  
    catch (Exception e){  
      pw.println(e);  
    }  

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


            
}

}
