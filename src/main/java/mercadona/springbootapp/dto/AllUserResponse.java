package mercadona.springbootapp.dto;

import java.util.List;

public class AllUserResponse {

	/** users */
	private List<UserDTO> users;
	
	/** numUsers */
	private Integer numUsers;

	public AllUserResponse() {
		super();
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public Integer getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(Integer numUsers) {
		this.numUsers = numUsers;
	}
	
	
	
}
