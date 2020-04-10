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

import gdsd.gator.model.Items;


@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List < Items > getItems() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Items > cq = cb.createQuery(Items.class);
        Root < Items > root = cq.from(Items.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteItem(int Id) {
        Session session = sessionFactory.getCurrentSession();
        Items theItem = session.byId(Items.class).load(Id);
        session.delete(theItem);
    }

    @Override
    public void saveItem(Items theItem) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theItem);
    }

    @Override
    public Items getItem(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Items theItem = currentSession.get(Items.class, theId);
        return theItem;
    }
    
    @Override
    public List <Items> getLatestItems(int theLim){
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" FROM Items AS i WHERE i.Status=? ORDER BY i.Id DESC ";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,1);
		@SuppressWarnings("unchecked")
		List <Items> list = ((org.hibernate.query.Query<Items>) query).list();

		if ((list != null) && (list.size() > 0)) {
			//userFound= true;
		}

		session.close();
		return list;              
   }
    
   @Override
   public List <Items> getBestDeals(){
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" FROM Items AS i WHERE i.Status=? ORDER BY i.Price ASC ";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,1);
		@SuppressWarnings("unchecked")
		List <Items> list = ((org.hibernate.query.Query<Items>) query).list();

		if ((list != null) && (list.size() > 0)) {
			//userFound= true;
		}

		session.close();
		return list;              
   }
   
   @Override
   public List <Items> getBestDealsCat(){
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" FROM Items AS i WHERE i.Status=? ORDER BY i.Categories,i.Price ASC ";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,1);
		@SuppressWarnings("unchecked")
		List <Items> list = ((org.hibernate.query.Query<Items>) query).list();

		if ((list != null) && (list.size() > 0)) {
			//userFound= true;
		}

		session.close();
		return list;              
   }
    

}
