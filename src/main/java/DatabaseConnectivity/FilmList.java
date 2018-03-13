package DatabaseConnectivity;

//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/FilmList")
public class FilmList
{	
		FilmFetch ff=new FilmFetch();
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public FilmResponse getflist()
	    {
	        return ff.getflist();
	    }
	    
	    @Path("/{film_id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public FilmResponse getflist(@PathParam("film_id")String film_id)
	    {
	        return ff.getflist(film_id);
	    }
	    
	    @Path("Title/{title}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public FilmResponse getfSlist(@PathParam("title")String title)
	    {
	        return ff.getfSlist(title);
	    }
	    
	    @Path("Delete/{film_id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public BaseResponse deletefilm(@PathParam("film_id") String film_id)
	    {
	    	return ff.deletefilm(film_id);
			
	    }
	    
	    @Path("Update/{film_id}/{dir_id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public BaseResponse updatefilm(@PathParam("film_id") String film_id,@PathParam("dir_id") String dir_id)
	    {
	    	return ff.Updatefilm(film_id,dir_id);
			
	    }
	    @Path("MovieCount/{fname}/{lname}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public MovieCountResponse getnooffilms(@PathParam("fname") String fname,@PathParam("lname") String lname)
	    {
	    	return ff.getnooffilms(fname,lname);
			
	    }
	    @Path("Actors")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public ActorResponse getalist()
	    {
	    	return ff.getalist();
			
	    }
	    organize o=new organize();
	    @Path("KBDegree/{actor1}/{actor2}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public BaseResponse init(@PathParam("actor1") String actor1,@PathParam("actor2") String actor2)
	    {
	    	return o.init(actor1,actor2);
			
	    }

}



