package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    
	private Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);//read data from configuration file
		}
		catch(Exception e)
		{
			System.out.println("Exception is: " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getIEPath()
	{
		String iePath = pro.getProperty("iePath");
		return iePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath = pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getOperaPath()
	{
		String operaPath = pro.getProperty("operaPath");
		return operaPath;
	}
}
