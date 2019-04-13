package ross.fyp.FYPRestfulWebService;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/addImage")
public class AddImage {

//	// HTTP Get Method
//		@POST
//		// Path: http://localhost/<appln-folder-name>/register/doregister
//		@Path("/doAddImage")  
//		// Produces JSON as response
//		@Produces(MediaType.APPLICATION_JSON) 
//		@Consumes(MediaType.MULTIPART_FORM_DATA) 
//public String uploadImage(@FormDataParam("file") InputStream uploadedInputStream,
//		@FormDataParam("file") FormDataContentDisposition fileDetail){
//			
//			//save the object file to the local disk 
//			saveToDisk(uploadedInputStream, fileDetail);
//			return "File uploaded successfully" ;
//			
//		}
//		
//		public String saveToDisk(InputStream uploadedInputStream,FormDataContentDisposition fileDetail) {
//			
//			String uploadedFileLocation = "d://upload/" + fileDetail.getFileName();
//			try {
//				OutputStream out = new FileOutputStream(new File(
//							uploadedFileLocation));
//				int read = 0;
//				byte[] bytes = new byte[1024];
//				
//				out = new FileOutputStream(new File(uploadedFileLocation));
//				while ((read = uploadedInputStream.read(bytes)) !=1 ) {
//					out.write(bytes, 0, read);
//				}
//				out.flush();
//				out.close();
//			}catch (IOException e) {
//				e.printStackTrace();
//			}
//			return null;
//			
//		}
		
		
		
}
