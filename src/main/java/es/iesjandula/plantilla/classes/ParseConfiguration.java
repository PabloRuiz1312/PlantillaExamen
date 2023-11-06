package es.iesjandula.plantilla.classes;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.plantilla.exception.PlantillaException;
/**
 * 
 * @author Pablo Ruiz Canovas
 *
 */
public class ParseConfiguration 
{
	/**Class logger*/
	private static Logger log = LogManager.getLogger();
	/**Attribute to parse in cmd*/
	private Option opt1;
	/**Attribute to parse in cmd*/
	//TODO:Set more option attributes
	private Option opt2;
	/**Attribute that store parameters */
	private CommandLine cmd;
	/**
	 * Constructor where the options are instance
	 */
	public ParseConfiguration()
	{
		this.opt1 = new Option("o1","option1",true,"Option 1 description");
		this.opt2 = new Option("o2","option2",true,"Option 2 description");
		this.cmd = null;
	}
	
	public Configuration parse(String [] args) throws PlantillaException
	{
		//Configuration object to parse the options
		Configuration configuration = null;
		//Option list
		Options options = new Options();
		options.addOption(opt1);
		options.addOption(opt2);
		
		try
		{
			this.cmd = new DefaultParser().parse(options,args);
			String strOpt1 = this.getCmdStringOption(opt1);
			String strOpt2 = this.getCmdStringOption(opt2);
			
			if(strOpt1.isEmpty())
			{
				String error = "Error la opcion1 esta vacia";
				log.error(error);
				throw new PlantillaException(error);
			}
			if(strOpt2.isEmpty())
			{
				String error = "Error la opcion1 esta vacia";
				log.error(error);
				throw new PlantillaException(error);
			}
			else
			{
				//TODO: Instance configuration object
				log.info("Configuration complete");
			}
		}
		catch(ParseException ex)
		{
			String error = "Error parsing the comands";
			log.fatal(error,ex);
			throw new PlantillaException(error,ex);
		}
		return configuration;
	}
	/**
	 * Return the String option value from the command line given the representing
	 * option
	 *
	 * @param option with the representing option of the command line
	 * @return the value of the option, null if unsettled
	 */
	private String getCmdStringOption(final Option option)
	{
		String outcome = null;

		if (this.cmd.hasOption(option.getOpt()))
		{
			outcome = this.cmd.getOptionValue(option.getOpt()).trim();
		} 
		else if (this.cmd.hasOption(option.getLongOpt()))
		{
			outcome = this.cmd.getOptionValue(option.getLongOpt()).trim();
		}

		return outcome;
	}
		
}

