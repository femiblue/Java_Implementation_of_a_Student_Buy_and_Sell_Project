package gdsd.gator.dao;

import java.util.List;

import gdsd.gator.model.Items;

public interface ItemDAO {
	
	public List < Items > getItems();

	public void saveItem(Items theItem);

	public Items getItem(int theId);

	public void deleteItem(int theId);
	
	public List < Items > getLatestItems(int theLim);
	public List < Items > getBestDeals();
	public List < Items > getBestDealsCat();

}
