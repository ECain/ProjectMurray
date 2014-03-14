package project.murray.json;

import org.json.JSONException;
import org.json.JSONObject;

public class FeatureServiceCreationError {
	private boolean success;
	private String errorMessage;
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_ERROR = "error";
	private static final String TAG_MESSAGE = "message";
	
	public FeatureServiceCreationError(String json) throws JSONException{
    	JSONObject obj = new JSONObject(json);
    	setSuccess(obj.getBoolean(TAG_SUCCESS));
    	JSONObject error = obj.getJSONObject(TAG_ERROR);
    	setErrorMessage(error.getString(TAG_MESSAGE));
    }
    
    //PROPERTIES
    public Boolean getSuccess(){
    	return success;
    }
    public void setSuccess(Boolean value){
    	success = value;
    }
    
    public String getErrorMessage(){
    	return errorMessage;
    }
    public void setErrorMessage(String value){
    	errorMessage = value;
    }    
}


