package mercadona.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINY")
public class Destiny {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "cod", nullable = false)
    private Integer cod;
	
	@Column(name = "address", nullable = false)
    private String address;
	
	@Column(name = "city", nullable = false)
    private String city;
	
	@Column(name = "postal_code", nullable = false)
    private String postalCode;
	 
    public Destiny() {
    	super();
	}

	public Destiny(long id, Integer cod, String name) {
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public long getId() {
        return id;
    }
    
    public Integer getCod() {
		return cod;
	}

    public String getName() {
        return name;
    }

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	

}