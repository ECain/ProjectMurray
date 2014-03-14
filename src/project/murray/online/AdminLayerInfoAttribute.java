package project.murray.online;

public class AdminLayerInfoAttribute {
	private GeometryField geometryField;
	
	public AdminLayerInfoAttribute(){
		geometryField = null;
	}
	
	public AdminLayerInfoAttribute(GeometryField geometryField1){
		geometryField = geometryField1;
	}
	
	public GeometryField geometryField(){
		return geometryField;
	}
	public void geometryField(GeometryField value){
		geometryField = value;
	}
}
