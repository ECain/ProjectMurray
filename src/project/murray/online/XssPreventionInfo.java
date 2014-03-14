package project.murray.online;

public class XssPreventionInfo{
	public boolean xssPreventionEnabled;
	public String xssPreventionRule;// = "InputOnly", //TODO: create an enum representation of values            
	public String  xssInputRule;// = "rejectInvalid"
}
