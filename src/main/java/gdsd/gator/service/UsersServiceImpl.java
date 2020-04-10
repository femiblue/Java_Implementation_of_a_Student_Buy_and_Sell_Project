package gdsd.gator.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdsd.gator.dao.UsersDAO;
import gdsd.gator.model.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
    private UsersDAO usersDAO;
	
	@Override
    @Transactional
    public List < Users > getUsers() {
        return usersDAO.getUsers();
    }
	
    @Override
    @Transactional
    public void saveUser(Users theUser) {
        usersDAO.saveUser(theUser);
    }

    @Override
    @Transactional
    public Users getUser(int theId) {
        return usersDAO.getUser(theId);
    }
    
    @Override
    @Transactional
    public void deleteUser(int theId) {
        usersDAO.deleteUser(theId);
    }
    
    @Override
    @Transactional
    public List <Users> checkLogin(String theUsername, String thePassword) {
    	return usersDAO.checkLogin(theUsername, thePassword);
    }


}
