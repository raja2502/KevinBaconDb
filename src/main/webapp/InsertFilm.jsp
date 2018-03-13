<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String mov_id = request.getParameter("mov_id");  
String title = request.getParameter("title");  
int length = Integer.parseInt(request.getParameter("duration"));  
String dir_id = request.getParameter("director_id");  
float rating = Float.parseFloat(request.getParameter("rating"));

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviesdb","root", "Raja1995!");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into movies(mov_id,title,director_id,duration,rating) values('"+mov_id+"','"+title+"','"+dir_id+"','"+length+"','"+rating+"')");
out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>