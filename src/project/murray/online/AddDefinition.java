package project.murray.online;

public class AddDefinition {
	private DefinitionLayer[] layers;
	
	public AddDefinition(){
		layers = null;
	}
	
	public AddDefinition(DefinitionLayer[] layerCollection){
		layers = layerCollection;
	}
	
	public DefinitionLayer[] layers(){
		return layers;
	}
	
	public void layers(DefinitionLayer[] value){
		layers = value;
	}
}
