package gdsd.gator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gdsd.gator.model.Seller;

@Service
public interface SellerService {
	
	public List < Seller > getSellers();

    public void saveSeller(Seller theSeller);

    public Seller getSeller(int theId);

    public void deleteSeller(int theId);
    
    public List <Seller> getSellerByItem(int theItemId);

}
