public class Caesar {

  public static void main( String args[] ) {
    System.out.print("#Enter key -25 .. 25: " );
    int key = BIO.getInt();
    EncryptDecrypt ed = new EncryptDecrypt();
    ed.setKey(key);
    System.out.print("#Enter line of text : " );
    String line = BIO.getString();
    while (!line.equals( "END")) {
      System.out.println("Original text: " + line );
      System.out.println("En/Decrypted : " + ed.process(line));
      System.out.print("#Enter line of text : " );
      line = BIO.getString();
    }
  }
}


class EncryptDecrypt {
  private int key = 0;
  private String text = "";
  
  public void setKey( int k ) {
    key = k;
  }
  
  public String process( String line) {
    line = line.toLowerCase();
    String res = "";
    for (int i=0; i<line.length(); i++) {
      char c = line.charAt(i); //Get ith char
      if (c >= 'a' && c <= 'z') {
        int chN = c-'a'; //Letter to number 0-25
        chN = chN + key; //move on key positions
        if (chN >= 0) chN = chN % 26; //Forward
	    else
		  chN = 26 + chN; //Reverse
		  c = (char) (chN+'a'); //Back to letter
		  res += c; //Append
		} 
      else {
		res += ' '; //Append space
      }
    }
  return res;
  }
}
