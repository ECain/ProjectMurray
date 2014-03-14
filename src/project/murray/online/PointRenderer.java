package project.murray.online;

public class PointRenderer extends Renderer{
	   // private String field1;
	    //private Symbol defaultSymbol;
	    private UniqueValueInfo[] uniqueValueInfos;
	    
	    public PointRenderer(){
	    	//this.field1 = null;
	    	//this.defaultSymbol = null;
	    	this.uniqueValueInfos = null;
	    	this.type = "";
			this.symbol = null;
			this.label = "";
			this.description = "";
	    }
	    
	    /*public String field1(){
	    	return field1;
	    }
	    public void field1(String value){
	    	field1 = value;
	    }
	    
	    public Symbol defaultSymbol(){
	    	return defaultSymbol;
	    }
	    public void defaultSymbol(Symbol value){
	    	defaultSymbol = value;
	    }*/
	    
	    public UniqueValueInfo[] uniqueValueInfos(){
	    	return uniqueValueInfos;
	    }
	    public void uniqueValueInfos(UniqueValueInfo[] value){
	    	uniqueValueInfos = value;
	    }
}
