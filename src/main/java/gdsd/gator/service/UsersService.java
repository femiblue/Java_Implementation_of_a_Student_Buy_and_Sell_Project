package gdsd.gator.service;

import java.util.List;

import gdsd.gator.model.Users;

public interface UsersService {
	
	public List < Users > getUsers();

    public void saveUser(Users theUser);

    public Users getUser(int theId);

    public void deleteUser(int theId);
    
    public List <Users> checkLogin(String theUsername, String thePassword);
}
