package ross.fyp.FYPRestfulWebService;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/register")
public class MyResource {

	// HTTP Get Method
		@POST
		// Path: http://localhost/<appln-folder-name>/register/doregister
		@Path("/doregister")  
		// Produces JSON as response
		@Produces(MediaType.APPLICATION_JSON) 
		@Consumes(MediaType.APPLICATION_JSON) 
		// Query parameters are parameters: http://localhost/<appln-folder-name>/register/doregister?name=pqrs&username=abc&password=xyz
		public String doLogin(User user){
			String response ="";
			//System.out.println("Inside doLogin "+uname+"  "+pwd);
			int retCode = registerUser(user.getName(), user.getEmail(), user.getPassword(), user.getCompanyId());
			if(retCode == 0){
				response = Utility.constructJSON("register","true");
			}else if(retCode == 1){
				response = Utility.constructJSON("register","false");
			}else if(retCode == 2){
				response = Utility.constructJSON("register","false");
			}else if(retCode == 3){
				response = Utility.constructJSON("register","false");
			}
			return response;

		}
		
		
		
		

		private int registerUser(String name,String email,String password,String companyId){
			System.out.println("Inside checkCredentials");
			int result = 3;
			if(Utility.isNotNull(email) && Utility.isNotNull(password)){
				try {
					if(DBConnection.insertUser(name, email, password, companyId)){
						System.out.println("RegisterUSer if");
						result = 0;
					}
				} catch(SQLException sqle){
					System.out.println("RegisterUser catch sqle");
					//When Primary key violation occurs that means user is already registered
					if(sqle.getErrorCode() == 1062){
						result = 1;
					} 
					//When special characters are used in name,email or password
					else if(sqle.getErrorCode() == 1064){
						System.out.println(sqle.getErrorCode());
						result = 2;
					}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Inside checkCredentials catch e ");
					result = 3;
				}
			}else{
				
				System.out.println("Inside checkCredentials else");
				result = 3;
			}

			return result;
		}

	}