package ross.fyp.FYPRestfulWebService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestTable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	String testCol;
	
	public TestTable() {
		
	}

	public TestTable(String testCol) {
		super();
		this.testCol = testCol;
	}

	public String getTestCol() {
		return testCol;
	}

	public void setTestCol(String testCol) {
		this.testCol = testCol;
	}
	
	
	
	
	
}
