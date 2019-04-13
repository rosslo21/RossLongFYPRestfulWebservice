package ross.fyp.FYPRestfulWebService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
//Path: http://localhost/<appln-folder-name>/login
@Path("/login")
public class Login {
	// HTTP Get Method
	@POST
	// Path: http://localhost/<appln-folder-name>/login/dologin
	@Path("/dologin")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	// Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
	public String doLogin(User user){
		String response = "";
		if(checkCredentials(user.getEmail(), user.getPassword())){
			response = Utility.constructJSON("login", "true");
		}else{
			response = Utility.constructJSON("login", "false");
		}
	return response;		
	}

	/**
	 * Method to check whether the entered credential is valid
	 * 
	 * @param uname
	 * @param pwd
	 * @return
	 */
	private boolean checkCredentials(String email, String password){
		//System.out.println("Inside checkCredentials");
		boolean result = false;
		if(Utility.isNotNull(email) && Utility.isNotNull(password)){
			System.out.println("inside check");
			try {
				result = DBConnection.checkLogin(email, password);
				//System.out.println("Inside checkCredentials try "+result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println("Inside checkCredentials catch");
				result = false;
			}
		}else{
			//System.out.println("Inside checkCredentials else");
			result = false;
		}

		return result;
	}

}