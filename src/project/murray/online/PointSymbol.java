package project.murray.online;

public class PointSymbol extends Symbol {
	private String url;
	private String contentType;
	private double height;
	private int angle;
	private int xoffset;
	private int yoffset;
	
	public PointSymbol(){
		
	}
	public PointSymbol(String url, String contentType, double height, int angle, int xoffset, int yoffset){
		this.url = url;
		this.contentType = contentType;
		this.height = height;
		this.angle = angle;
		this.xoffset = xoffset;
		this.yoffset = yoffset;
	}
	
	public String url(){
		return url;
	}
	public void url(String value){
		url = value;
	}
	
	public String contentType(){
		return contentType;
	}	
	public void contentType(String value){
		contentType = value;
	}
	
	public double height(){
		return height;
	}	
	public void height(double value){
		height = value;
	}
	
	public int angle(){
		return angle;
	}	
	public void angle(int value){
		angle = value;
	}
	
	public int xoffset(){
		return xoffset;
	}
	public void xoffset(int value){
		xoffset = value;
	}
	
	public int yoffset(){
		return yoffset;
	}
	public void yoffset(int value){
		yoffset = value;
	}
	
	/*
	public String imageData(){
		return _imageData;
	}
	public void imageData(String value){
		_imageData = value;
	}
	 
	public String type(){
		return _type;
	}	
	public void type(String value){
		_type = value;
	}
	
	public Object color(){
		return _color;
	}	
	public void color(Object value){
		_color = value;
	}
	
	public double width(){
		return _width;
	}	
	public void width(double value){
		_width = value;
	}
	*/
	
	
}
