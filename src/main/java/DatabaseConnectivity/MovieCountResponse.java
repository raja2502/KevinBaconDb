package DatabaseConnectivity;

import java.util.List;

public class MovieCountResponse {
	public List<MovieCount> count;

	public List<MovieCount> getActors() {
		return count;
	}

	public void setActors(List<MovieCount> count) {
		this.count = count;
	}

}
