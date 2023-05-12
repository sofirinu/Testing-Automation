package setup;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;


public class Init extends PageObject{
	
	private  static EnvironmentVariables envVars;
	private  EnvironmentVariables env;
	
	// to get url from Serenity.properties
	public static String getAppUrl1test() {
		String appUrl = null;
		envVars = SystemEnvironmentVariables.createEnvironmentVariables();
		appUrl = System.getProperty("appUrl234234","").toString();
		
		if (appUrl.equals("")) {
			appUrl = envVars.getProperty("appUrl234234");
		}
		System.out.println("Url opened from Init file is " + appUrl);
		return appUrl;
	}
	
	// to get url from Serenity.conf
	public String getAppUrl() {
		
		System.out.println("Url opened from Init file is " + EnvironmentSpecificConfiguration.from(env).getProperty("appUrl"));
		return EnvironmentSpecificConfiguration.from(env).getProperty("appUrl");
		
		}
	

}
