package gdsd.gator.model;

//import java.awt.TextArea;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "item")
public class Items {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
	
	@Column(name = "Name") 
 	private String Name;
	
	@Column(name = "Categories") 
 	private String Categories;
	
	@Column(name = "Price")
    private int Price;
	
	@Column(name = "Description", columnDefinition="TEXT") 
 	private String Description;
	
	@Nullable
	@Column(name = "Photo") 
 	private String Photo;
	
	@Column(name = "Status")
    private int Status;
	
	@Column(name="Date", columnDefinition="TIMESTAMP")  
	@UpdateTimestamp
	private ZonedDateTime Date;
	
    public Items() {

    }
	
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
    
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getCategories() {
        return Categories;
    }
    
    public void setCategories(String Categories) {
        this.Categories = Categories;
    }
    
    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public String getPhoto() {
        return Photo;
    }
    
    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
	
    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    public ZonedDateTime getDate() {
        return Date;
    }

    public void setDate(ZonedDateTime Date) {
        this.Date = Date;
    }
	
	@Override
    public String toString() {
        return "Items [Id=" + Id + ", Name=" + Name + ", Categories=" + Categories + ", Price=" + Price + ", Description=" + Description +", Photo=" + Photo + ", Status=" + Status +", Date=" + Date +"]";
    }

}
