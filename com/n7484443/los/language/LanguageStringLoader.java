package com.n7484443.los.language;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.newdawn.slick.util.ResourceLoader;

import com.n7484443.los.main.Core;

public class LanguageStringLoader {
	public static File SettingFile;
	public static File LanguageFile;
	public static String Language;
	public static HashMap<String, String> language= new HashMap<String, String>();
	public static void init(){
		SettingFile = new File("c:/LeaderOfSpecies/setting.set");
		try {
			FileReader fis = new FileReader(SettingFile);
			BufferedReader b_reader = new BufferedReader(fis);
			String str;
			while((str = b_reader.readLine()) != null){
				if(str.contains("Version")){
					Core.version = str.substring(str.indexOf("{")+1, str.indexOf("}"));
				}else if(str.contains("Language")){
					Language = str.substring(str.indexOf("{")+1, str.indexOf("}"));
				}
			}
			b_reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LanguageFile = new File("c:/LeaderOfSpecies/language." + Language);
		try {
			BufferedReader b_reader;
			
			if(Language.equals("kor")){
				b_reader = new BufferedReader(new InputStreamReader(new FileInputStream(LanguageFile),"euc-kr"));
			}else{
				FileReader fis = new FileReader(LanguageFile);
				b_reader = new BufferedReader(fis);
			}
			String str;
			while((str = b_reader.readLine()) != null){
				language.put(str.split("=")[0], str.split("=")[1]);
			}
			b_reader.close();
		} catch (IOException e) {
			System.out.println("지원되지 않는 언어입니다!");
		}
	}
	public static String getLanguage(String firststr){
		if(language.containsKey(firststr)){
			return language.get(firststr);
		}else{
			return null;
		}
	}
}
