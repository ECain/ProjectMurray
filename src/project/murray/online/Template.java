package project.murray.online;

public class Template {	 
	private String name;
	private String description;
	private String drawingTool;
	private Prototype prototype;
	
	public Template(){
		
	}
	
	public Template(String name, String description, String drawingTool, Prototype protoType){
		this.name = name;
		this.description = description;
		this.drawingTool = drawingTool;
		this.prototype = protoType;
	}
	
	public String name(){
		return name;
	}
	public void name(String value){
		name = value;
	}
	
	public String description(){
		return description;
	}
	public void description(String value){
		description = value;
	}
	
	public String drawingTool(){
		return drawingTool;
	}
	public void drawingTool(String value){
		drawingTool = value;
	}
	
	public Prototype prototype(){
		return prototype;
	}
	public void prototype(Prototype value){
		prototype = value;
	}
}
