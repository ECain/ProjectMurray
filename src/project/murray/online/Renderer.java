package project.murray.online;

public class Renderer {
	protected String type; 
	protected Symbol symbol; 
	protected String label; 
	protected String description; 
	
	public Renderer(){
		type = "";
		symbol = null;
		label = "";
		description = "";
	}
	
	public String type(){
		return type;
	}
	public void type(String value){
		type = value;
	}
	
	public Symbol symbol(){
		return symbol;
	}
	public void symbol(Symbol value){
		symbol = value;
	}
	
	public String label(){
		return label;
	}
	public void label(String value){
		label = value;
	}
	
	public String description(){
		return description;
	}
	public void description(String value){
		description = value;
	}
}



