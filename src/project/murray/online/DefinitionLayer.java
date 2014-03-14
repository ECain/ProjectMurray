package project.murray.online;

//import org.json.JSONException;
//import org.json.JSONObject;

public class DefinitionLayer {

	private boolean defaultVisibility = false;
    private boolean allowGeometryUpdates = false;
    private boolean hasAttachments = false;
    private boolean hasM = false;
    private boolean hasZ = false;
	private boolean isDataVersioned = false;
	private boolean supportsRollbackOnFailureParameter = false;
	private boolean supportsStatistics = false;
	private boolean supportsAdvancedQueries = false;
	private boolean hasStaticData = false;
	private double 	currentVersion = -1.0;
	private DrawingInfo drawingInfo = null; 
    private Extent 	extent = null; 
	private int    	id = -1;
	private int 	maxRecordCount = -1;
    private int 	minScale = -1;
    private int 	maxScale = -1;
    private Index[] indexes = null;
    private Object 	relationships = null;
    private Object 	fields = null;
    private Object 	types = null;
    private Object 	adminLayerInfo = null;
    private String 	name = null;
	private String 	type = null;
	private String 	displayField = null;
	private String 	description = null;
	private String 	copyrightText = null;
	private String 	geometryType = null;
	private String 	htmlPopupType = null;
	private String 	supportedQueryFormats = null; 
    private String 	objectIdField = null;
    private String 	globalIdField = null;  
    private String 	typeIdField = null;
    private String 	capabilities = null; 
    private Template[] templates = null;   
    
    public DefinitionLayer(){
    
    }
    
    public Index[] Indexes(){
    	return indexes;
    }
    public void Indexes(Index[] value){
    	indexes = value;
    }
    
    public double currentVersion(){
    	return currentVersion;
    }
    public void currentVersion(double value){
    	currentVersion = value;
    }
    
    public int id(){
    	return id;
    }
    public void id(int value){
    	id = value;
    }
    
	public String name(){
		return name;
	}
	public void name(String value){
    	name = value;
    }
	
	public String type(){
		return type;
	}
	public void type(String value){
    	type = value;
    }
	
	public String displayField(){
		return displayField;
	}
	public void displayField(String value){
    	displayField = value;
    }
	
	public String description(){
		return description;
	}
	public void description(String value){
    	description = value;
    }
	
	public String copyrightText(){
		return copyrightText;
	}
	public void copyrightText(String value){
    	copyrightText = value;
    }
	
	public boolean defaultVisibility(){
		return defaultVisibility;
	}
	public void defaultVisibility(boolean value){
    	defaultVisibility = value;
    }
	
	public Object relationships(){
		return relationships;
	}
	public void relationships(Object value){
    	relationships = value;
    }
	
	public boolean isDataVersioned(){
		return isDataVersioned;
	}
	public void isDataVersioned(boolean value){
    	isDataVersioned = value;
    }
	
	public boolean supportsRollbackOnFailureParameter(){
		return supportsRollbackOnFailureParameter;
	}
	public void supportsRollbackOnFailureParameter(boolean value){
		supportsRollbackOnFailureParameter = value;
    }
	
	public boolean supportsStatistics(){
		return supportsStatistics;
	}
	public void supportsStatistics(boolean value){
		supportsStatistics = value;
    }
	
	public boolean supportsAdvancedQueries(){
		return supportsAdvancedQueries;
	}
	public void supportsAdvancedQueries(boolean value){
		supportsAdvancedQueries = value;
    }
	
	public String geometryType(){
		return geometryType;
	}
	public void geometryType(String value){
    	geometryType = value;
    }
	
	public int minScale(){
		return minScale;
	}
	public void minScale(int value){
    	minScale = value;
    }
	
	public int maxScale(){
		return maxScale;
	}
	public void maxScale(int value){
    	maxScale = value;
    }
	
	public Extent extent(){
		return extent;
	}
	public void extent(Extent value){
    	extent = value;
    }
	
	public DrawingInfo drawingInfo(){
		return drawingInfo;
	}
	public void drawingInfo(DrawingInfo value){
    	drawingInfo = value;
    }
	 
	public boolean allowGeometryUpdates(){
		return allowGeometryUpdates;
	}
	public void allowGeometryUpdates(boolean value){
    	allowGeometryUpdates = value;
    }
	
	public boolean hasAttachments(){
		return hasAttachments;
	}
	public void hasAttachments(boolean value){
    	hasAttachments = value;
    }
	
	public String htmlPopupType(){
		return htmlPopupType;
	}
	public void htmlPopupType(String value){
    	htmlPopupType = value;
    }
	
	public boolean hasM(){
		return hasM;
	}
	public void hasM(boolean value){
    	hasM = value;
    }
	
	public boolean hasZ(){
		return hasZ;
	}
	public void hasZ(boolean value){
    	hasZ = value;
    }
	
	public String objectIdField(){
		return objectIdField;
	}
	public void objectIdField(String value){
    	objectIdField = value;
    }
	
	public String globalIdField(){
		return globalIdField;
	}
	public void globalIdField(String value){
    	globalIdField = value;
    }
	 
	public String typeIdField(){
		return typeIdField;
	}
	public void typeIdField(String value){
    	typeIdField = value;
    }
	
	public Object fields(){
		return fields;
	}
	public void fields(Object jsonObject){
    	fields = jsonObject;
    }
	
	public Object types(){
		return types;
	}
	public void types(Object value){
    	types = value;
    }
	
	public Template[] templates(){
		return templates;
	}
	public void templates(Template[] value){
    	templates = value;
    }
	  
	public String supportedQueryFormats(){
		return supportedQueryFormats;
	}
	public void supportedQueryFormats(String value){
    	supportedQueryFormats = value;
    }
	   
	public boolean hasStaticData(){
		return hasStaticData;
	}
	public void hasStaticData(boolean value){
    	hasStaticData = value;
    }
	 
	public int maxRecordCount(){
		return maxRecordCount;
	}
	public void maxRecordCount(int value){
    	maxRecordCount = value;
    }
	  
	public String capabilities(){
		return capabilities;
	}
	public void capabilities(String value){
    	capabilities = value;
    }
	
	public Object adminLayerInfo(){
		return adminLayerInfo;
	}
	public void adminLayerInfo(Object value){
    	adminLayerInfo = value;
    }

}
