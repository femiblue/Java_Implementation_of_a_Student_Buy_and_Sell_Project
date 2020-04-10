package gdsd.gator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gdsd.gator.model.Items;

@Service
public interface ItemService {
	
	public List < Items > getItems();

    public void saveItem(Items theItem);

    public Items getItem(int theId);

    public void deleteItem(int theId);
    
    public List < Items > getLatestItems(int Lim);
    
    public List < Items > getBestDeals();
    
    public List < Items > getBestDealsCat();

}
