package es.iesjandula.plantilla.classes;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * 
 * @author Pablo Ruiz Canovas
 *
 */
public class MyObjectOutputStream extends ObjectOutputStream 
{
	/**
	 * Constructor that creates a object output stream with a diferent header
	 * @param out
	 * @throws IOException
	 */
	public MyObjectOutputStream(OutputStream out) throws IOException	
	{
		super(out);
	}
	@Override
	protected void writeStreamHeader()
	{
		
	}
}
