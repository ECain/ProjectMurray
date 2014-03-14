package project.murray.online;

public class Outline {
	private String type;
	private String style;
	private Object color;
	private double width;
	
	public Outline(){
		
	}
		
	public String get_type(){
		return type;
	}
	public void set_type(String value){
		type = value;
	}
	
    public String get_style(){
		return style;
	}
	public void set_style(String value){
		style = value;
	}
	
    public Object get_color(){
		return color;
	}
	public void set_color(Object value){
		color = value;
	}
	
    public double get_width(){
		return width;
	}
	public void set_width(double value){
		width = value;
	}
	
}
