package project.murray.online;

public class Index {
	private String name;
	private String fields;
	private boolean isUnique;
	private boolean isAscending;
	private String description;
	               
	public Index(String name, String fields, boolean isUnique, boolean isAscending, String description){
		this.name = name;
		this.fields = fields;
		this.isUnique = isUnique;
		this.isAscending = isAscending;
		this.description = description;
	}
	
	public String Name(){
		return name;
	}
	public void Name(String value){
		name = value;
	}
	
	public String Fields(){
		return fields;
	}
	public void Fields(String value){
		fields = value;
	}
	
	public boolean IsUnique(){
		return isUnique;
	}
	public void IsUnique(boolean value){
		isUnique = value;
	}
	
	public boolean IsAscending(){
		return isAscending;
	}
	public void IsAscending(boolean value){
		isAscending = value;
	}
	
	public String Description(){
		return description;
	}
	public void Description(String value){
		description = value;
	}
}
