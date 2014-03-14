package project.murray.online;

public class LabelInfoSymbol {
	private String type;
    private Object[] color;
    private Object[] backgroundColor;
    private Object[] borderLineColor;  
    private String verticalAlignment;  
    private String horizontalAlignment;
    private Boolean rightToLeft;
    private int angle;
    private int xoffset;
    private int yoffset;
    private Object font;
    
    public LabelInfoSymbol(){
    	
    }
    
    public String get_type(){
    	return type;
    }
    public void set_type(String value){
    	type = value;
    }
    
    public Object[] get_color(){
    	return color;
    }
    public void set_color(Object[] value){
    	color = value;
    }
    
    public Object[] get_backgroundColor(){
    	return backgroundColor;
    }
    public void set_backgroundColor(Object[] value){
    	backgroundColor = value;
    }
    
    public Object[] get_borderLineColor(){
    	return borderLineColor;
    }
    public void set_borderLineColor(Object[] value){
    	borderLineColor = value;
    }
    
    public String get_verticalAlignment(){
    	return verticalAlignment;
    }
    public void set_verticalAlignment(String value){
    	verticalAlignment = value;
    }
    
    public String get_horizontalAlignment(){
    	return horizontalAlignment;
    }
    public void set_horizontalAlignment(String value){
    	horizontalAlignment = value;
    }
    
    public Boolean get_rightToLeft(){
    	return rightToLeft;
    }
    public void set_rightToLeft(Boolean value){
    	rightToLeft = value;
    }
    
    public int get_angle(){
    	return angle;
    }
    public void set_angle(int value){
    	angle = value;
    }
    
    public int get_xoffset(){
    	return xoffset;
    }
    public void set_xoffset(int value){
    	xoffset = value;
    }
    
    public int get_yoffset(){
    	return yoffset;
    }
    public void set_yoffset(int value){
    	yoffset = value;
    }
    
    public Object get_font(){
    	return font;
    }
    public void set_font(Object value){
    	font = value;
    }
    
}
