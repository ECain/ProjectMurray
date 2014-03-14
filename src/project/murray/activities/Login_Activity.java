package project.murray.activities;

import project.murray.R;
import project.murray.json.Self;
import project.murray.online.HttpWebRequestHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Activity extends Activity {
	Button _authenticateButton;
	Button _cancelButton;
	EditText _username;
	EditText _password;
	EditText _organizationURL;
	
	String _token = null;
	Self _self = null;
	Thread _thread;
	TextView _usersData;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		_username = (EditText)findViewById(R.id.loginUserName);
		_password = (EditText)findViewById(R.id.editTextPassword);
		_organizationURL = (EditText)findViewById(R.id.textEditOrgID);
		_authenticateButton = (Button)findViewById(R.id.SignInButton);
		_authenticateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
            	 _thread = new Thread(new Runnable() {
            		public void run() {
            			try {	
            				final String[] args = {_username.getText().toString(), _password.getText().toString(), _organizationURL.getText().toString()};
            				_token = HttpWebRequestHelper.GetToken(args);
            				String[] tokensArgs = {_token};
            				String selfString = HttpWebRequestHelper.GetSelf(tokensArgs);
            				_self = new Self(selfString); 
            				Intent returnIntent = new Intent();
            				returnIntent.putExtra("Token", _token);
            				returnIntent.putExtra("ORG_ID", _self.getOrganisation_ID());
            	            setResult(RESULT_OK,returnIntent);     
            	            finish();
            			} catch (Exception e) {
            				e.printStackTrace();
            			}
            		}
            	});
            	_thread.start();
            	
            	try {
        			_thread.join();
        			ShowUserInfo();
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
            }
		});
		
		_cancelButton = (Button)findViewById(R.id.signInCancelButton);
		
		_cancelButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent returnIntent = new Intent();
	            setResult(RESULT_CANCELED,returnIntent);     
	            finish();
           	};
		});
	}

	private void ShowUserInfo(){
		_usersData = (TextView)findViewById(R.id.userOrgData);
		
		if(_self != null){
			_usersData.setText("Name: " + _self.getFullName() + "\r\n");
			_usersData.append("Email: " + _self.getEmail() + "\r\n");
			_usersData.append("Storage Usage: " + _self.getStorage_Usage() + "\r\n");
			_usersData.append("Storage Quota: " + _self.getStorage_Quota() + "\r\n");
			_usersData.append("Org ID: " + _self.getOrganisation_ID() + "\r\n");
			_usersData.append("Role: " + _self.getRole() + "\r\n");
			_usersData.append("Access: " + _self.getUserAccess() + "\r\n");
		}
	}
}
