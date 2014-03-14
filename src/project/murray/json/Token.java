package project.murray.json;
import org.json.JSONException;
import org.json.JSONObject;

public class Token {
	// JSON Node names
	private static final String TAG_TOKEN = "token";
	//private static final String TAG_EXPIRES = "expires";
	//private static final String TAG_SSL = "ssl";
	
	public static String GetToken(String json) throws JSONException{
		JSONObject obj = new JSONObject(json);
		String token = obj.getString(TAG_TOKEN);
		//long expires = obj.getLong(TAG_EXPIRES);
		//Boolean ssl = obj.getBoolean(TAG_SSL);
		        
		return token;
	}
}
	
