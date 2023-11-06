package es.iesjandula.plantilla.exception;
/**
 * 
 * @author Pablo Ruiz Canovas
 *
 */
public class PlantillaException extends Exception 
{
	/**
	 * Complete constructor that create a exception
	 * @param error
	 * @param ex
	 */
	public PlantillaException(String error,Exception ex)
	{
		super(error,ex);
	}
	/**
	 * Constructor that create a exception using a string
	 * @param error
	 */
	public PlantillaException(String error)
	{
		super(error);
	}
}
