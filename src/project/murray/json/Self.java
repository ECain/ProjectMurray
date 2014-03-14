package project.murray.json;
import org.json.JSONException;
import org.json.JSONObject;

public class Self{
	private String username = null;
	private String fullname = null;
	private String email = null;
	private String access = null;
	private long storageUsage = 0;
	private long storageQuota = 0;
	private String orgID = null;
	private String role = null;
	
	private static final String TAG_USERNAME = "username";
	private static final String TAG_FULLNAME = "fullName";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_ACCESS = "access";
	private static final String TAG_STORAGE_USAGE = "storageUsage"; //ulong
	private static final String TAG_STORAGE_QUOTA = "storageQuota"; //ulong
    private static final String TAG_ORGANISATION_ID = "orgId";
    private static final String TAG_ROLE = "role";
    
    //No code implementation for these items, included them for reference.
	private static final String TAG_PREFERREDVIEW = "preferredView";
	private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_TAGS = "tags"; //Object[]
    private static final String TAG_CULTURE = "culture";
    private static final String TAG_REGION = "region";
    private static final String TAG_THUMBNAIL = "thumbnail";
    private static final String TAG_CREATED = "created"; //long
    private static final String TAG_MODIFIED = "modified"; //long
    private static final String TAG_GROUP = "groups"; //Group[] = 
	private static final String TAG_ID = "id";
	private static final String TAG_TITLE = "title";
    private static final String TAG_IS_INVITATION_ONLY = "isInvitationOnly";  //BOOLEAN  
    private static final String TAG_OWNER = "owner";     
    private static final String TAG_GROUP_DESCRIPTION = "description";
    private static final String TAG_SNIPPET = "snippet";
    private static final String TAG_GROUP_TAGS = "tags"; //String[]
    private static final String TAG_PHONE = "phone";     
    private static final String TAG_GROUP_THUMBNAIL = "thumbnail";
    private static final String TAG_GROUP_CREATED = "created";  //ULONG
    private static final String TAG_GROUP_MODIFIED = "modified"; //ulong
    private static final String TAG_GROUP_ACCESS = "access";    
    private static final String TAG_USER_MEMBERSHIP = "userMembership";  //object    
	private static final String TAG_MEMBERSHIP_USERNAME = "username";
    private static final String TAG_MEMBERTYPE = "memberType";
    private static final String TAG_APPLICATIONS = "applications"; //integer
    
    
    public Self(String json) throws JSONException{
    	JSONObject obj = new JSONObject(json);
    	setUserName(obj.getString(TAG_USERNAME));
    	setFullName(obj.getString(TAG_FULLNAME));
    	setEmail(obj.getString(TAG_EMAIL));
    	setUserAccess(obj.getString(TAG_ACCESS));
    	setStorage_Usage(obj.getLong(TAG_STORAGE_USAGE));
    	setStorage_Quota(obj.getLong(TAG_STORAGE_QUOTA));
    	setOrganisation_ID(obj.getString(TAG_ORGANISATION_ID));
    	setRole(obj.getString(TAG_ROLE));
    }
    
    //PROPERTIES
    public String getUserName(){
    	return username;
    }
    public void setUserName(String value){
    	username = value;
    }
    
    public String getFullName(){
    	return fullname;
    }
    public void setFullName(String value){
    	fullname = value;
    }
    
	public String getEmail(){
		return email;
	}
	public void setEmail(String value){
		email = value;
	}
	
	public String getUserAccess(){
		return access;
	}
	public void setUserAccess(String value){
	    access = value;
	}
	
	public long getStorage_Usage(){
		return storageUsage;
	}
	public void setStorage_Usage(long value){
		storageUsage = value;
	}
	
	public long getStorage_Quota(){
		return storageQuota;
	}
	public void setStorage_Quota(long value){
		storageQuota = value;
	}
	
	public String getOrganisation_ID (){
		return orgID;
	}
	public void setOrganisation_ID (String value){
		orgID = value;
	}
	
	public String getRole(){
		return role;
	}
	public void setRole(String value){
		role = value;
	}
}
