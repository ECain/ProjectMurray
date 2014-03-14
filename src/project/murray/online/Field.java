package project.murray.online;

import org.json.JSONException;
import org.json.JSONObject;

public class Field {
	private String name;
	private String type;
	private String alias;
	private String sqlType;
	private boolean nullable;
	private boolean editable;
	private Object domain = null;
	private Object defaultValue = null;
	private Object length = null;
	
	private static final String TAG_NAME = "name";
	private static final String TAG_TYPE = "type";
	private static final String TAG_ALIAS = "alias";
	private static final String TAG_SQLTYPE = "sqlType";
	private static final String TAG_NULLABLE = "nullable";
	private static final String TAG_EDITABLE = "editable";
	//private static final String TAG_DOMAIN = "domain";
	//private static final String TAG_DEFAULTVALUE = "defaultValue";
	//private static final String TAG_LENGTH = "length";
	
	public Field(JSONObject obj) throws JSONException{
		setName(obj.getString(TAG_NAME));
		setType(obj.getString(TAG_TYPE));
		setAlias(obj.getString(TAG_ALIAS));
		setSqlType(obj.getString(TAG_SQLTYPE));
		setIsNullable(obj.getBoolean(TAG_NULLABLE));
		setEditable(obj.getBoolean(TAG_EDITABLE));
	}
	
	public Field(){
	
	}
	
	public String getName(){
		return name;
	}
	public void setName(String value){
		name = value;
	}
	
	public String getType()
	{
		return type;
	}
	public void setType(String value)
	{
		type = value;
	}
	
	public String getAlias(){
		return alias;
	}
	public void setAlias(String value){
		alias = value;
	}
	
	public String getSqlType(){
		return sqlType;
	}
	public void setSqlType(String value){
		sqlType = value;
	}
	
	public boolean getIsNullable(){
		return nullable;
	}
	public void setIsNullable(boolean value){
		nullable = value;
	}
	
	public boolean getEditable(){
		return editable;
	}
	public void setEditable(boolean value){
		editable = value;
	}
	
	//TODO: Extend if you ever want to set these values
	public Object Domain(){
		return domain;
	}
	public void Domain(Object value){
		domain = value;
	}
	
	public Object DefaultValue(){
		return defaultValue;
	}
	public void DefaultValue(Object value){
		defaultValue = value;
	}
	public Object Length(){
		return length;
	}
	public void Length(Object value){
		length = value;
	}
}
