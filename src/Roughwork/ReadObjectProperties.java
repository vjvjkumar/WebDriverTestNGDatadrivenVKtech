package Roughwork;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadObjectProperties {
	
  public static void main(String[] args) throws Exception{

// Creating Object for OR Properties
	  Properties OR = new Properties();
	  
//Creating Object for FileInputStream (OR properties)
	  FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/com/vktech/config/OR.properties");

//Loading the file in the OR-Properties file
	  OR.load(ip);
	  System.out.println(OR.getProperty("logLink"));
	  System.out.println(OR.getProperty("logbuttonLOGIN"));
	  
	  

//Creating Object for CONFIG Properties
	  Properties CONFIG = new Properties();
	  
//Creating Object for FileInputStream (CONFIG Properties)
	  FileInputStream cp = new FileInputStream(System.getProperty("user.dir")+"/src/com/vktech/config/config.properties");

//Loading the file in the CONFIG-Properties file
	  CONFIG.load(cp);
	  System.out.println(CONFIG.getProperty("browsertype"));
	  System.out.println(System.getProperty("user.dir"));
  }
} 
	  
 
  
	  
