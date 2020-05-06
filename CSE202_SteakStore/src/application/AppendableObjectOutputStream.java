package application;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * 
 * @author Danny, Jak, Jacob, Grant
 *Writes entered data into an appendable output
 * */
public class AppendableObjectOutputStream extends ObjectOutputStream {
	  public AppendableObjectOutputStream(OutputStream out) throws IOException {
	    super(out);
	  }
	  @Override
	  protected void writeStreamHeader() throws IOException {}
}