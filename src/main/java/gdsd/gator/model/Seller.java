package gdsd.gator.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "seller")
public class Seller {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
	
	@Column(name = "UserId") 
 	private int UserId;
	
	@Column(name = "ItemId") 
 	private int ItemId;
	
	public Seller() {

    }
	
	public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
    
    
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }
    
    @Override
    public String toString() {
        return "Item [Id=" + Id + ", UserId=" + UserId + ", ItemId=" + ItemId + "]";
    }

}
