import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/** Simple servlet for testing. Generates HTML instead of plain
 *  text as with the HelloWorld servlet.
 */

@WebServlet("ci502/imgSrv")
public class ImgServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      //create the in and output streams
     try (FileInputStream fin = new FileInputStream("ci502/WEB-INF/images.jpg");
	      BufferedInputStream bin = new BufferedInputStream(fin);
	      OutputStream out = response.getOutputStream();
	      BufferedOutputStream bout = new BufferedOutputStream(out)) {
	      
	      int ch = 0;
	      
	      while ((ch = bin.read())!=-1){
      		bout.write(ch);
      	      }
      	      
      	  //because of the try and catch block i dont need to close the resources because they are closed when the try block is completed
      	 } catch (FileNotFoundException e){
      	 //handle the case where the image file is not found
      	 response.sendError(HttpServletResponse.SC_NOT_FOUND, "image not found");
      	 } catch (IOException e){
      	 //handles general I/O errors
      	 response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error serving the image");
      	 }
      }
  }
