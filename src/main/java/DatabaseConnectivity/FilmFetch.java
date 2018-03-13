package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class FilmFetch 
{
	Connection conn=null;
	public FilmResponse getfSlist(String title)
	{
		List<Film> fl=new ArrayList<Film>();
		FilmResponse chres=new FilmResponse();
		Dbconnection db=new Dbconnection();
		conn=db.getconnection();
		try 
		{	
			String name = null;
			Statement sql=conn.createStatement();
			ResultSet rs=sql.executeQuery("select Mov_Id,Title,Duration,language,year,rating,FirstName,Lastname from movies inner join  directors on movies.director_id=directors.dir_id where title="+title);
			while(rs.next()){
			Film f=new Film();
			f.setId(rs.getString("MOV_ID"));
			f.setTitle(rs.getString("Title"));
			f.setDuration(rs.getInt("Duration"));
			f.setLanguage(rs.getString("Language"));
			f.setRating(rs.getInt("rating"));
			f.setYear(rs.getInt("year"));
			name=rs.getString("FirstName");
			name+=" "+rs.getString("LastName");
			f.setDirector_Name(name);
			fl.add(f);
			}
			chres.setfilms(fl);
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return chres;

}
	
	public ActorResponse getalist()
	{
		List<Actor> fl=new ArrayList<Actor>();
		ActorResponse chres=new ActorResponse();
		Dbconnection db=new Dbconnection();
		conn=db.getconnection();
		try 
		{	String name=null;
			Statement sql=conn.createStatement();
			ResultSet rs=sql.executeQuery("select * from actors");
			while(rs.next()){
			Actor f=new Actor();
			f.setMOV_ID(rs.getString("ACT_ID"));
			f.setFname(rs.getString("firstname"));
			f.setLname(rs.getString("lastname"));
			name=rs.getString("firstname")+" "+rs.getString("lastname");
			f.setName(name);
			fl.add(f);
			}
			chres.setActors(fl);
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return chres;

}
	
	public FilmResponse getflist(String id)
	{
		List<Film> fl=new ArrayList<Film>();
		FilmResponse chres=new FilmResponse();
		Dbconnection db=new Dbconnection();
		conn=db.getconnection();
		try 
		{	
			String name = null;
			Statement sql=conn.createStatement();
			ResultSet rs=sql.executeQuery("select Mov_Id,Title,Duration,language,year,rating,FirstName,Lastname from movies inner join  directors on movies.director_id=directors.dir_id where Mov_Id="+id);
			while(rs.next()){
			Film f=new Film();
			f.setId(rs.getString("MOV_ID"));
			f.setTitle(rs.getString("Title"));
			f.setDuration(rs.getInt("Duration"));
			f.setLanguage(rs.getString("Language"));
			f.setRating(rs.getInt("rating"));
			f.setYear(rs.getInt("year"));
			name=rs.getString("FirstName");
			name+=" "+rs.getString("LastName");
			//System.out.println(rs.getString("MOV_ID")+" "+ rs.getString("Title"));
			f.setDirector_Name(name);
			fl.add(f);
			}
			chres.setfilms(fl);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return chres;
}
	
	public FilmResponse getflist()
	
	{
		List<Film> fl=new ArrayList<Film>();
		FilmResponse chres=new FilmResponse();
		Dbconnection db=new Dbconnection();
		conn=db.getconnection();
		try 
		{	
			String name = null;
			Statement sql=conn.createStatement();
			ResultSet rs=sql.executeQuery("select Mov_Id,Title,Duration,language,year,rating,FirstName,Lastname from movies inner join  directors on movies.director_id=directors.dir_id");
			while(rs.next()){
			Film f=new Film();
			f.setId(rs.getString("MOV_ID"));
			f.setTitle(rs.getString("Title"));
			f.setDuration(rs.getInt("Duration"));
			f.setLanguage(rs.getString("Language"));
			f.setRating(rs.getInt("rating"));
			f.setYear(rs.getInt("year"));
			name=rs.getString("FirstName");
			name+=" "+rs.getString("LastName");
			f.setDirector_Name(name);
			fl.add(f);
			}
			chres.setfilms(fl);
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return chres;

}

	public BaseResponse deletefilm(String id)
{
	Dbconnection db=new Dbconnection();
	conn=db.getconnection();
	Boolean status=false;
	BaseResponse br=new BaseResponse();
	try 
	{	
		Statement sql=conn.createStatement();
		int r=sql.executeUpdate("delete from movies where MOV_ID="+id);
		if(r!=0)
			status=true;
		if(status)
			br.setMessage("Record Deleted Sucessfully !");
		else
			br.setMessage("No Records Deleted!");
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return br;
}
	
	public MovieCountResponse getnooffilms(String fname,String lname){
		List<MovieCount> fl=new ArrayList<MovieCount>();
		Dbconnection db=new Dbconnection();
		conn=db.getconnection();
		MovieCountResponse ar=new MovieCountResponse();
		try 
		{	
			Statement sql=conn.createStatement();
			ResultSet rs=sql.executeQuery("select year,count(title) as number_ofmovies from movie_cast as cast,actors,movies,directors where movies.mov_id=cast.mov_id and actors.act_id=cast.act_id and director_id=Dir_ID and actors.FirstName ='"+fname+"' and actors.LastName='"+lname+"' group by year");
			while(rs.next()){
			MovieCount a=new MovieCount();
			a.setNo_of_movies(rs.getInt(2));
			a.setYear(Integer.toString(rs.getInt("year")));
			fl.add(a);
			}
			ar.setActors(fl);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ar;
	}
	
	public BaseResponse Updatefilm(String id,String dir_id)
{
	Dbconnection db=new Dbconnection();
	conn=db.getconnection();
	Boolean status=false;
	BaseResponse br=new BaseResponse();
	try 
	{	
		Statement sql=conn.createStatement();
		int r=sql.executeUpdate("update movies set director_id="+dir_id+"where MOV_ID="+id);
		if(r!=0)
			status=true;
		if(status)
			br.setMessage("Record Updated Sucessfully !");
		else
			br.setMessage("No Records Updated!");
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return br;
}

}

