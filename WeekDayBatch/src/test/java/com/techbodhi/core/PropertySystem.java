package com.techbodhi.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Abhishek Jain
 *
 */
public class PropertySystem {
	private Properties applicationProps = new Properties();
	
	public PropertySystem(String filePath){
		try {
		InputStream is = new FileInputStream(filePath);
		applicationProps.load(is);
		is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String Key){
		
		return applicationProps.getProperty(Key);
		
	}
	
//{
//	private Properties applicationProps = new Properties();
//
//    public PropertySystem(String filePath)
//    {
//        try 
//        {
//            InputStream is = new FileInputStream(filePath);
//            applicationProps.load(is);
//            is.close();
//        }
//        catch(FileNotFoundException fnfe)
//        {
//        	fnfe.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public String getProperty(String key)
//    {
//        return applicationProps.getProperty(key);
//    }	
}
