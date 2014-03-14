package project.murray.online;

public class UniqueValueInfo {
	private String value;
	private String label; 
	private String description;
	private Symbol symbol;
	
	public UniqueValueInfo(){
		value = "";
		label = "";
		description = "";
		symbol = null;
	}
	
	public String value(){
		return this.value;
	}
	public void value(String value){
		this.value = value;
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
	
	public Symbol symbol(){
		return symbol;
	}
	public void symbol(Symbol value){
		symbol = value;
	}
}
