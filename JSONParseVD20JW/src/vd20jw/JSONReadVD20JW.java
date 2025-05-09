package vd20jw;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadVD20JW {
	public static void main(String[] args) {
		try(FileReader reader = new FileReader("VD20JW_orarend.json")){
			//Parse
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
			
			//Root, majd óra lista elérése
			JSONObject root = (JSONObject) jsonObject.get("VD20JW_orarend");
			JSONArray lessons = (JSONArray) root.get("ora");
			
			//Óra adatok kiírása
			System.out.println("Órarend 2025 tavasz:\n");
			
			for(int i=0; i<lessons.size();i++) {
				JSONObject lesson = (JSONObject) lessons.get(i);
				JSONObject time = (JSONObject) lesson.get("idopont");
				System.out.println("Tárgy: " + lesson.get("kurzus"));
				System.out.println("Időpont: " + time.get("nap") + " " + time.get("tol") + " " + time.get("ig"));
				System.out.println("Helyszín: " + lesson.get("helyszin"));
				System.out.println("Oktató: " + lesson.get("oktato"));
				System.out.println("Szak: " + lesson.get("szak"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
