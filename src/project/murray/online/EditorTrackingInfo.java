package project.murray.online;

public class EditorTrackingInfo{
	private boolean enableEditorTracking;
	private boolean enableOwnershipAccessControl;
	private boolean allowOthersToUpdate;
	private boolean allowOthersToDelete;
	
	public EditorTrackingInfo(){
		enableEditorTracking = false;
		enableOwnershipAccessControl = false;
		allowOthersToUpdate = false;
		allowOthersToDelete = false;
	}
	
	public EditorTrackingInfo(boolean enableEditTracking, boolean enableOwnershipAccessCtrl, boolean allowOthersToUpdt, boolean allowOthersToDel){
		enableEditorTracking = enableEditTracking;
		enableOwnershipAccessControl = enableOwnershipAccessCtrl;
		allowOthersToUpdate = allowOthersToUpdt;
		allowOthersToDelete = allowOthersToDel;
	}
	
	public boolean enableEditorTracking(){
		return enableEditorTracking;
	}
	public void enableEditorTracking(boolean value){
		enableEditorTracking = value;
	}

	public boolean enableOwnershipAccessControl(){
		return enableOwnershipAccessControl;
	}
	public void enableOwnershipAccessControl(boolean value){
		enableOwnershipAccessControl = value;
	}

	public boolean allowOthersToUpdate(){
		return allowOthersToUpdate;
	}
	public void allowOthersToUpdate(boolean value){
		allowOthersToUpdate = value;
	}

	public boolean allowOthersToDelete(){
		return allowOthersToDelete;
	}
	public void allowOthersToDelete(boolean value){
		allowOthersToDelete = value;
	}
}
