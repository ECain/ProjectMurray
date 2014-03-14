package project.murray.online;

import org.json.JSONException;
import org.json.JSONObject;

public class Extent {
	private double xmin = 0.0;
	private double ymin = 0.0;
    private double xmax = 0.0;
    private double ymax = 0.0;
    private SpatialReference spatialReference = null;
    
    private static final String TAG_XMIN = "xmin";
    private static final String TAG_YMIN = "ymin";
    private static final String TAG_XMAX = "xmax";
    private static final String TAG_YMAX = "ymax";
    private static final String TAG_SPATIAL_REFERENCE = "spatialreference";
    
    public Extent(double xmx, double xmn, double ymx, double ymn, SpatialReference spatialRef){
    	Xmax(xmx);
    	Xmin(xmn);
    	Ymax(ymx);
    	Ymin(ymn);
    	SpatialReference(spatialRef);
    }
    
    public Extent(JSONObject obj) throws JSONException{
    	Xmax(obj.getDouble(TAG_XMAX));
    	Xmin(obj.getDouble(TAG_XMIN));
    	Ymax(obj.getDouble(TAG_YMAX));
    	Ymin(obj.getDouble(TAG_YMIN));
    	SpatialReference(new SpatialReference(obj.getJSONObject(TAG_SPATIAL_REFERENCE)));
    }
    
  //PROPERTIES
    public double Xmax(){
    	return xmax;
    }
    public void Xmax(double value){
    	xmax = value;
    }
    
    public double Xmin(){
    	return xmin;
    }
    public void Xmin(double value){
    	xmin = value;
    }
    
    public double Ymax(){
    	return ymax;
    }
    public void Ymax(double value){
    	ymax = value;
    }
    
    public double Ymin(){
    	return ymin;
    }
    public void Ymin(double value){
    	ymin = value;
    }
    
    public SpatialReference SpatialReference(){
    	return spatialReference;
    }
    public void SpatialReference(SpatialReference value){
    	spatialReference = value;
    }
}
