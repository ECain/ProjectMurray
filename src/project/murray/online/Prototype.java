package project.murray.online;

public class Prototype {
	private Attributes attributes;
	
	public Prototype(){
		attributes = null;
	}
	
	public Prototype(Attributes attributes){
		this.attributes = attributes;
	}
	
	public Attributes attributes(){
		return attributes;
	}
}
