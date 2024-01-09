package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;



public class File_Utility {

	/**
	 * This method used to read common data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Selvi
	 */
	
	public String getStringKeyAndValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(iPathConstant.FILE_PATH);
		
	//	FileInputStream fis = new FileInputStream("src/test/resources/commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

}
