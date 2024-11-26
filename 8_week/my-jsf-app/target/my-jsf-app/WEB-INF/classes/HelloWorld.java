package ci502.jsf; 
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
   
  public HelloWorld() {
  }
 
  public String getMessage() {
     return "Hello World from JSF Bean!";
  }
}
