package project.murray.online;

public class LabelingInformation {

	private String labelPlacement;
    private String labelExpression;
    private Boolean useCodedValues;
    private LabelInfoSymbol symbol;
    private int minScale;
    private int maxScale;
    
    public LabelingInformation(){
    	
    }
    
    public String get_labelPlacement(){
    	return labelPlacement;
    }
    public void set_labelPlacement(String value){
    	labelPlacement = value;
    }
    
    public String get_labelExpression(){
    	return labelExpression;
    }
    public void set_labelExpression(String value){
    	labelExpression = value;
    }
    
    public Boolean get_useCodedValues(){
    	return useCodedValues;
    }
    public void set_labelPlacement(Boolean value){
    	useCodedValues = value;
    }
    
    public LabelInfoSymbol get_symbol(){
    	return symbol;
    }
    public void set_labelPlacement(LabelInfoSymbol value){
    	symbol = value;
    }
    
    public int get_minScale(){
    	return minScale;
    }
    public void set_minScale(int value){
    	minScale = value;
    }
    
    public int get_maxScale(){
    	return maxScale;
    }
    public void set_maxScale(int value){
    	maxScale = value;
    }
}
