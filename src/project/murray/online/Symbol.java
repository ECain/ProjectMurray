package project.murray.online;

public class Symbol {
	private String type;
	//private String style;
	//private Object color;
	//private Outline outline;
	private String imageData; 
	private double width ;
	
	public Symbol(){
		this.type = "";
		//this.style = "";
		//this.color = null;
		//this.outline = null;
		this.imageData = "";
		this.width = -1.0;
	}
	
	public String type(){
		return type;
	}
	public void type(String value){
		type = value;
	}
	
    /*public String style(){
		return style;
	}
	public void style(String value){
		style = value;
	}
	
    public Object color(){
		return color;
	}
	public void color(Object value){
		color = value;
	}
	
	public Outline outline(){
		return outline;
	}
	public void outline(Outline value){
		outline = value;
	}*/
	
    public double width(){
		return width;
	}
	public void width(double value){
		width = value;
	}
	
	public String imageData(){
		return imageData;
	}
	public void imageData(String value){
		imageData = value;
	}
}
