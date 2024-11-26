package navigate;

import javax.faces.bean.*;

@ManagedBean
public class NavBean {
  private String someData;

  public String getSomeData() {
    return(someData);
  }

  public void setSomeData(String someData) {
    this.someData = someData;
  }
  
  public String actionMethod() {
    return("some-page");
  }
}
