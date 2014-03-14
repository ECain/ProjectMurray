package project.murray.online;

import org.json.JSONException;
import org.json.JSONObject;

public class SpatialReference {
	private long wkid;
	private long latestWkid;
	
	public static final String TAG_WKID = "wkid";    
	public static final String TAG_LATESTWKID = "latestWKid";  
		    
	public SpatialReference(long wKid, long latestWKid){
		wkid = wKid;
		latestWkid = latestWKid;
	}
	
	public SpatialReference(JSONObject spatRefObj) throws JSONException {
		WKID(spatRefObj.getLong(TAG_WKID));
		LatestWKID(spatRefObj.getLong(TAG_LATESTWKID));
	}

	public long WKID(){
		return wkid;
	}
	public void WKID(long value){
		wkid = value;
	}
	
	public long LatestWKID(){
		return latestWkid;
	}
	public void LatestWKID(long value){
		latestWkid = value;
	}
}
