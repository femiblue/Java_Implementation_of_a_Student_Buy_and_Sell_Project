package gdsd.gator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "users")
public class Users {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name") 
 	private String Name;
    
    @Column(name = "Username")
    private String Username;
    
    @Column(name = "Email")
    private String Email;
    
    @Column(name = "Password")
    private String Password;
    
    @Column(name = "Photo")
    @Nullable
    private String Photo;
    
    @Column(name = "Post")
    @Nullable
    private Integer Post = 0;
    
    public Users() {

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
    
    public String getUsername() {
        return Username;
    }
    
    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getPhoto() {
        return Photo;
    }
    
    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
    
    public Integer getPost() {
        return Post;
    }
    
    public void setPost(Integer Post) {
        this.Post = Post;
    }
    
    @Override
    public String toString() {
        return "Users [Id=" + Id + ", Name=" + Name + ", Username=" + Username + ", Email=" + Email + ", Password=" + Password +", Photo=" + Post + "]";
    }
    
}
