package project.murray.json;

import org.json.JSONException;
import org.json.JSONObject;

//import android.os.Parcel;
//import android.os.Parcelable;

public class FeatureServiceCreationSuccess {
	private String encodedServiceURL;
	private String itemId;
	private String name;
	private String serviceItemId;
	private String serviceurl;
	private int size;
	private boolean success;
	private String type;
	
	private static final String TAG_ENCODED_SERVICE_URL = "encodedServiceURL";
	private static final String TAG_ITEM_ID = "itemId";
	private static final String TAG_NAME = "name";
	private static final String TAG_SERVICE_ITEM_ID = "serviceItemId";
	private static final String TAG_SERVICE_URL = "serviceurl";
	private static final String TAG_SIZE = "size";
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_TYPE = "type";
	
	public FeatureServiceCreationSuccess(String json) throws JSONException{
		JSONObject obj = new JSONObject(json);
		set_EncodedServiceURL(obj.getString(TAG_ENCODED_SERVICE_URL));
		set_ItemId(obj.getString(TAG_ITEM_ID));
		set_Name(obj.getString(TAG_NAME));
		set_ServiceItemId(obj.getString(TAG_SERVICE_ITEM_ID));
		set_Serviceurl(obj.getString(TAG_SERVICE_URL));
		set_Size(obj.getInt(TAG_SIZE));
		set_Type(obj.getString(TAG_TYPE));
		set_Success(obj.getBoolean(TAG_SUCCESS));
	}
	
	public String get_EncodedServiceURL(){
		return encodedServiceURL;
	}
	public void set_EncodedServiceURL(String value){
		encodedServiceURL = value;
	}
	
	public String get_ItemId(){
		return itemId;
	}
	public void set_ItemId(String value){
		itemId = value;
	}
	
	public String get_Name(){
		return name;
	}
	public void set_Name(String value){
		name = value;
	}
	
	public String get_ServiceItemId(){
		return serviceItemId;
	}
	public void set_ServiceItemId(String value){
	    serviceItemId = value;
	}
	
	public String get_Serviceurl(){
		return serviceurl;
	}
	public void set_Serviceurl(String value){
		serviceurl = value;
	}
	
	public int get_Size(){
		return size;
	}
	public void set_Size(int value){
		size = value;
	}
	
	public boolean get_Success(){
		return success;
	}
	public void set_Success(boolean value){
		success = value;
	}
	
	public String get_Type(){
		return type;
	}
	public void set_Type(String value){
		type = value;
	}

}
