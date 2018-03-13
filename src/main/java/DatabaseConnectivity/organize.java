package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



// Building block for Link between Actor and Movie.
class Neighbor {
	int vertexNum; 
	String movie;
	Neighbor next;
	public Neighbor (int num, String _movie, Neighbor ngh ) {
		vertexNum = num;
		movie = _movie;
		next = ngh;
	}
	public String toString() {
		return ":--> " + movie + next;
	}
}
public class organize {

	public BaseResponse init(String actor1,String actor2)
	{	
		BaseResponse br=new BaseResponse();
		StringBuffer str = new StringBuffer();
		// Init Graph class
		Graph graph = new Graph();
		Dbconnection db=new Dbconnection();
		Connection conn=null;
		conn=db.getconnection();
		String act1_name = null;
		String act2_name = null;
		String title = null;
		try 
		{	
			Statement sql=conn.createStatement();
			ResultSet rs=sql.executeQuery("select * from cast1");
			while(rs.next()){
			act1_name=rs.getString("actor1");
			act2_name=(rs.getString("actor2"));
			title=(rs.getString("Title"));
			graph.makeEdge(act1_name, act2_name, title);
			}
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		int vertIndex = graph.computePaths(actor1, actor2);
		int prevIndex;
		String relationship = "";
		if (vertIndex == -1){
			System.out.println("No links were found!");
			str.append(actor1 +" ---------> " +  actor2 + ":<h1> No links were found!</h1>");
		}
		else if (vertIndex == -2){
			str.append(actor1 +" ---------> " +  actor2 +"<h1>The degree of separation is greater than 6. It is not possible!</h1>");
		}
		else {
			System.out.println("1" +" -> " +  "2" + ": " + graph.adjLists[vertIndex].degree + " degree of separation");
			str.append("<h3>"+ actor1 +" ---------> " +  actor2 + ":</h3><p> " + graph.adjLists[vertIndex].degree + "</p><h3> degree of separation</h3>");
			prevIndex = graph.adjLists[vertIndex].whoBroughtYouIn;
			while (prevIndex!= -1)
			{		
				relationship += graph.getMovie(vertIndex, prevIndex) + ": " + graph.adjLists[prevIndex].actor + "; " + graph.adjLists[vertIndex].actor + "'\n";
				vertIndex = prevIndex;
				prevIndex = graph.adjLists[prevIndex].whoBroughtYouIn;
			}
			// Reversing relationship for output. Relation for Actor1->Actor2 and not Actor2->Actor1
			String [] relations = relationship.split("'\n");
			str.append("<ol style='font-size: 40px;background: #ff9999;padding: 30px;' type='I'>");
			for (int i = relations.length - 1; i > -1; i-- ) {
				System.out.println(relations[i]);
				str.append("<li style='background: #ffe5e5;padding: 15px;margin-left: 35px;'>"+relations[i]+"</li>");
			}
			str.append("</ol>");
		}
		
		br.setStr(str);
		return br;
	}

}