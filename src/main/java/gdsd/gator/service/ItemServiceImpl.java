package gdsd.gator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdsd.gator.dao.ItemDAO;
import gdsd.gator.model.Items;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
    private ItemDAO itemDAO;
	
	@Override
    @Transactional
    public List < Items > getItems() {
        return itemDAO.getItems();
    }
	
    @Override
    @Transactional
    public void saveItem(Items theItem) {
    	itemDAO.saveItem(theItem);
    }

    @Override
    @Transactional
    public Items getItem(int theId) {
        return itemDAO.getItem(theId);
    }
    
    @Override
    @Transactional
    public void deleteItem(int theId) {
    	itemDAO.deleteItem(theId);
    }
    
    @Override
    @Transactional
    public List <Items> getLatestItems(int theLim) {
    	return itemDAO.getLatestItems(theLim);
    }
    
    @Override
    @Transactional
    public List <Items> getBestDeals() {
    	return itemDAO.getBestDeals();
    }
    
    @Override
    @Transactional
    public List <Items> getBestDealsCat() {
    	return itemDAO.getBestDealsCat();
    }
}
