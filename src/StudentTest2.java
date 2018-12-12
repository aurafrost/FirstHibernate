import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="StudentTest2")
public class StudentTest2 {
	@Id
	private int id;
	private String name;
	@Column(nullable=true)
	private String address;
	@Column(columnDefinition="number(10,2)")
	private double fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
}
