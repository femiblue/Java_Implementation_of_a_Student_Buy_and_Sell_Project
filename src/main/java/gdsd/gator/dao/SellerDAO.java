package gdsd.gator.dao;

import java.util.List;

import gdsd.gator.model.Seller;

public interface SellerDAO {
	
	public List < Seller > getSellers();

	public void saveSeller(Seller theSeller);

	public Seller getSeller(int theId);

	public void deleteSeller(int theId);
	
	public List <Seller> getSellerByItem(int theItemId);
}
