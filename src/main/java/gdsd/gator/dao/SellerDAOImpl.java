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

import gdsd.gator.model.Items;
import gdsd.gator.model.Seller;

@Repository
public class SellerDAOImpl implements SellerDAO {
	
	
	@Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List < Seller > getSellers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Seller > cq = cb.createQuery(Seller.class);
        Root < Seller > root = cq.from(Seller.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteSeller(int Id) {
        Session session = sessionFactory.getCurrentSession();
        Seller theSeller = session.byId(Seller.class).load(Id);
        session.delete(theSeller);
    }

    @Override
    public void saveSeller(Seller theSeller) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theSeller);
    }

    @Override
    public Seller getSeller(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Seller theSeller = currentSession.get(Seller.class, theId);
        return theSeller;
    }
    
    @Override
    public List <Seller> getSellerByItem(int theItemId){
 		Session session = sessionFactory.openSession();
 		//boolean userFound = false;
 		//Query using Hibernate Query Language
 		String SQL_QUERY =" FROM Seller AS s WHERE s.ItemId=? ";
 		Query query = session.createQuery(SQL_QUERY);
 		query.setParameter(0,theItemId);
 		@SuppressWarnings("unchecked")
 		List <Seller> list = ((org.hibernate.query.Query<Seller>) query).list();

 		if ((list != null) && (list.size() > 0)) {
 			//userFound= true;
 		}

 		session.close();
 		return list;              
    }

}
