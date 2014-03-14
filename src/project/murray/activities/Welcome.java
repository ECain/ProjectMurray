package project.murray.activities;

import project.murray.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome extends Activity {

	Button _getStarted;
	String _orgContentJSON;
	String _token;
	String _orgID;
	Thread _thread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		_getStarted = (Button) findViewById(R.id.btnGetStarted);
		_getStarted.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent login = new Intent(Welcome.this, Login_Activity.class);
				startActivityForResult(login, 1);
			};
		});
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {

			if (resultCode == RESULT_OK) {
				String orgID = (String) data.getStringExtra("ORG_ID");
				if(orgID != null){
					_orgID = orgID;
				}
				
				String token = (String) data.getStringExtra("Token");
				if (token != null) {
					if (!token.isEmpty())
					{
						_token = token;
						CreateFeatureServiceName();
					}
				}
				
				String name = (String) data.getStringExtra("FeatureServiceName");
				if (name != null) {
					Intent createFeatureService = new Intent(Welcome.this, CreateFeatureService_Activity.class);
					createFeatureService.putExtra("Token", _token);
					createFeatureService.putExtra("ORG_ID", _orgID);
					createFeatureService.putExtra("FeatureServiceName", name);
					startActivityForResult(createFeatureService, 1);
				}
				
				Boolean success = (Boolean)data.getBooleanExtra("CreationSuccess", false);
				if (success) {
					try{		
					Intent successIntent = new Intent(Welcome.this, Success_Activity.class);				
					startActivityForResult(successIntent, 1);
					}catch(Exception e){
						Context context = getApplicationContext();
						CharSequence text = "Error showing success page";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				}
				
				Boolean createAnotherFeatureService = (Boolean)data.getBooleanExtra("CreateAnother", false);
				if(createAnotherFeatureService){
					CreateFeatureServiceName();
				}
			}

			if (resultCode == RESULT_CANCELED) {
				finish();
			}
		}
	}

	private void CreateFeatureServiceName(){
		Intent featureServiceName = new Intent(Welcome.this, FeatureServiceName.class);
		featureServiceName.putExtra("Token", _token);
		startActivityForResult(featureServiceName, 1);
	}
}
