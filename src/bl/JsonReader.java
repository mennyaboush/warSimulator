package bl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.*;

import Enum.City;

public class JsonReader {
	private final static String FILE_NAME="data.json";
	private final static String WAR="war";
	private final static String MISSILE_LAUNCHERS="missileLaunchers";
	private final static String LAUNCHER="launcher";
	private final static String MISSILE_DESTRUCTORS="missileDestructors";
	private final static String DESTRUCTOR="destructor";
	private final static String MISSILE_LAUNCHERS_DESTRUCTORS="missileLauncherDestructors";
	private final static String ID="id";
	private final static String IS_HIDDEN="isHidden";
	private final static String MISSILE="missile";
	private final static String LAUNCHE_TIME="launchTime";
	private final static String DAMAGE="damage";
	private final static String FLY_TIME="flyTime";
	private final static String DESTINATION="destination";
	private final static String DESTRUCTED_MISSILE="destructdMissile";
	private final static String DESTRUCTED_AFTER_LAUNCHE="destructAfterLaunch";
	private final static String DESTRUCTED_LAUNCHER="destructedLanucher";
	private final static String TYPE="type";
	private final static String DESTRUCT_TIME="destructTime";
	
	private JSONObject warJsonObj;
	
	public JsonReader() throws IOException, JSONException{
		String jsonData = readFile(FILE_NAME);
		JSONObject initialJsonObj = new JSONObject(jsonData);
		warJsonObj=initialJsonObj.getJSONObject(WAR); 
	}
	
	public ArrayList<Launcher> ReadLaunchers() throws JSONException{
		ArrayList<Launcher> launchersList = new ArrayList<>();
		ArrayList<Missile> missilesList = null;
		JSONObject jsonLauncher;
		JSONArray jsonLaunchers=warJsonObj.getJSONObject(MISSILE_LAUNCHERS).getJSONArray(LAUNCHER);
		for (int i = 0; i < jsonLaunchers.length(); i++) {
			jsonLauncher=(JSONObject)jsonLaunchers.get(i);
			JSONArray jsonMissiles = jsonLauncher.getJSONArray(MISSILE);
			missilesList=new ArrayList<>();
			for (int j = 0; j < jsonMissiles.length(); j++) {
				JSONObject jsonMissile= (JSONObject)jsonMissiles.get(j);
				Missile missile =new Missile
						(jsonMissile.getString(ID),
								jsonMissile.getString(DESTINATION),
								jsonMissile.getInt(LAUNCHE_TIME), 
								jsonMissile.getInt(FLY_TIME), 
								jsonMissile.getInt(DAMAGE));
				missilesList.add(missile);
			}  
			Launcher launcher=new Launcher(jsonLauncher.getString(ID),City.GAZA ,jsonLauncher.getBoolean(IS_HIDDEN), missilesList);
			launchersList.add(launcher);
		}
		return launchersList;
	}
	
	public ArrayList<MissileDestructors> readMissileDestructor() throws JSONException{
		ArrayList<MissileDestructors> missileDestructorsList = new ArrayList<>();
		ArrayList<MissileD> destructedMissileList = null;
		JSONObject jsonMissileDestructor;
		JSONArray jsonMissileDestructors=warJsonObj.getJSONObject(MISSILE_DESTRUCTORS).getJSONArray(DESTRUCTOR);
		for (int i = 0; i < jsonMissileDestructors.length(); i++) {
			jsonMissileDestructor=(JSONObject)jsonMissileDestructors.get(i);
			destructedMissileList=new ArrayList<>();
			JSONArray jsonDestructedMissiles = null;
			JSONObject jsonDestructedMissile=null;
			boolean isArr=true;
			try {
				jsonDestructedMissiles = jsonMissileDestructor.getJSONArray(DESTRUCTED_MISSILE);
			} catch (Exception e) {
				if(e.getMessage().contains("is not a JSONArray")){	
					jsonDestructedMissile=jsonMissileDestructor.getJSONObject(DESTRUCTED_MISSILE);
				isArr=false;
				}
				else 
					e.printStackTrace();
			}
			if(isArr){
				for (int j = 0; j < jsonDestructedMissiles.length(); j++) {
					jsonDestructedMissile = (JSONObject)jsonDestructedMissiles.get(j);
					MissileD destructedMissile = new MissileD(jsonDestructedMissile.getString(ID), jsonDestructedMissile.getInt(DESTRUCTED_AFTER_LAUNCHE));
					destructedMissileList.add(destructedMissile);
				} 
			} else {
				
				destructedMissileList.add(new MissileD(jsonDestructedMissile.getString(ID),
						jsonDestructedMissile.getInt(DESTRUCTED_AFTER_LAUNCHE)));
			}
			MissileDestructors missileDestructor=new MissileDestructors(jsonMissileDestructor.getString(ID), destructedMissileList);
			missileDestructorsList.add(missileDestructor);
		}
		return missileDestructorsList;
	}
	
	public ArrayList<LauncherDestructors> readMissileLauncherDestructors() throws JSONException{
		ArrayList<LauncherDestructors> launcherDistractorList = new ArrayList<>();
		ArrayList<Missile> launcherDistractorMissileList = null;
		JSONObject jsonMissileLauncherDestructor;
		JSONArray jsonMissileLauncherDestructors=warJsonObj.getJSONObject(MISSILE_LAUNCHERS_DESTRUCTORS).getJSONArray(DESTRUCTOR);
		for (int i = 0; i < jsonMissileLauncherDestructors.length(); i++) {
			jsonMissileLauncherDestructor=(JSONObject)jsonMissileLauncherDestructors.get(i);
			launcherDistractorMissileList=new ArrayList<>();
			JSONArray jsonDestructedLanuchers = null;
			JSONObject jsonDestructedLanucher = null;
			boolean isArr=true;
			try {
				jsonDestructedLanuchers =jsonMissileLauncherDestructor.getJSONArray(DESTRUCTED_LAUNCHER);//(JSONArray)jsonDestructedLanuchersObj;
			} catch (Exception e) {
				if(e.getMessage().contains("is not a JSONArray")){	
					jsonDestructedLanucher=jsonMissileLauncherDestructor.getJSONObject(DESTRUCTED_LAUNCHER);
				isArr=false;
				}
				else 
					e.printStackTrace();
			}
			if(isArr){
				for (int j = 0; j < jsonDestructedLanuchers.length(); j++) {
					jsonDestructedLanucher= (JSONObject)jsonDestructedLanuchers.get(j);
					Missile destructedLanucher=new Missile(jsonDestructedLanucher.getString(ID), jsonDestructedLanucher.getInt(DESTRUCT_TIME));
					launcherDistractorMissileList.add(destructedLanucher);
				} 
			} else {
				launcherDistractorMissileList.add(new Missile(jsonDestructedLanucher.getString(ID), jsonDestructedLanucher.getInt(DESTRUCT_TIME)));
			}
			LauncherDestructors launcherDistractor=new LauncherDestructors(jsonMissileLauncherDestructor.getString(TYPE),launcherDistractorMissileList);
			launcherDistractorList.add(launcherDistractor);
		}
		return launcherDistractorList;
	}
	
	
	
	private static String readFile(String filename) throws IOException {
	    String result = "";
	    BufferedReader br = null;
	    try {
	         br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	    	br.close();
	        e.printStackTrace();
	    }
	    br.close();
	    return result;
	}

}
