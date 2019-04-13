package ross.fyp.FYPRestfulWebService;

public class User {
	
	private String name;
    private String email;
    private String password;
    private String companyId;
   
    // @OneToMany
    // List<Blob> images;
    public User(String n,String e,String p,String c) {
        this.name = n;
    	this.email = e;
        this.password = p;
        this.companyId = c;
    }

    public User() {

    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setCompanyId(String companyId) {
    	this.companyId = companyId;
    }
    
    public String getCompanyId() {
    	return companyId;
    	
    }
}
