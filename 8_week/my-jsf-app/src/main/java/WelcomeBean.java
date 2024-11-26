package ci502.jsf;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class WelcomeBean{

	public WelcomeBean(){
	}
    		public String getMessage(){
      		return "I am alive!";

   		}
}
