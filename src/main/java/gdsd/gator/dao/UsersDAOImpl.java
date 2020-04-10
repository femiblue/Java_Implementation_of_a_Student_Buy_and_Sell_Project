package gdsd.gator.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import java.util.Properties;

import gdsd.gator.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List < Users > getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Users > cq = cb.createQuery(Users.class);
        Root < Users > root = cq.from(Users.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteUser(int Id) {
        Session session = sessionFactory.getCurrentSession();
        Users theUser = session.byId(Users.class).load(Id);
        session.delete(theUser);
    }

    @Override
    public void saveUser(Users theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public Users getUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Users theUser = currentSession.get(Users.class, theId);
        return theUser;
    }
    
    @Override
    public List <Users> checkLogin(String theUsername, String thePassword){
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Users as u where u.Username=? and u.Password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,theUsername);
		query.setParameter(1,thePassword);
		@SuppressWarnings("unchecked")
		List <Users> list = ((org.hibernate.query.Query<Users>) query).list();

		if ((list != null) && (list.size() > 0)) {
			//userFound= true;
		}

		session.close();
		return list;              
   }
}
