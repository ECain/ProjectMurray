package project.murray.online;

public class GeometryField {
	private String name;
    private long srid;
    
    public GeometryField(){
    	
    }
    
    public GeometryField(String name1, long srid1){
    	name = name1;
    	srid = srid1;
    }
    
    public String name(){
    	return name;
    }
    public void name(String value){
    	name = value;
    }
    
    public long srid(){
    	return srid;
    }
    public void srid(long value){
    	srid = value;
    }
}
