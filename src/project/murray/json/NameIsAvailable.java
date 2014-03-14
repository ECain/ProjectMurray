package project.murray.json;

import org.json.JSONException;
import org.json.JSONObject;

public class NameIsAvailable {
	// JSON Node names
		private static final String TAG_ISAVAILABLE = "available";
		
		public static Boolean IsAvailable(String json) throws JSONException{
			JSONObject obj = new JSONObject(json);
			Boolean available = obj.getBoolean(TAG_ISAVAILABLE);
			        
			return available;
		}
}
