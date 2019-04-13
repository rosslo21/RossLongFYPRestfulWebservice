package ross.fyp.FYPRestfulWebService;

public class Blob {
	
	
	  private String blob;
	    private String imageName;

	    public Blob(String b, String i){
	        this.blob = b;
	        this.imageName = i;
	    }


	    public Blob(){

	    }

	    public String getBlob() {
	        return blob;
	    }

	    public void setBlob(String blob) {
	        this.blob = blob;
	    }

	    public String getImageName() {
	        return imageName;
	    }

	    public void setImageName(String imageName) {
	        this.imageName = imageName;
	    }



}
