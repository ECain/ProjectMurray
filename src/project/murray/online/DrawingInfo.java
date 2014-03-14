package project.murray.online;

public class DrawingInfo {

	private Renderer renderer;	   
	//private int transparency;
	private LabelingInformation[] labelingInfo; 
    
	public DrawingInfo(){
	 renderer = null;
	// transparency = 0;
	 labelingInfo = null;
	}
	
	public Renderer renderer(){
		return renderer;
	}
	public void renderer(Renderer value){
		renderer = value;
	}
	   
    /*public int transparency(){
    	return transparency;
    }
    public void transparency(int value){
    	transparency = value;
    }*/

    public LabelingInformation[] labelingInfo(){
    	return labelingInfo;
    }
    public void labelingInfo(LabelingInformation[] value){
    	labelingInfo = value;
    }
}
