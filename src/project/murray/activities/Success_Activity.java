package project.murray.activities;

import project.murray.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Success_Activity extends Activity {
	Button _ok;
	Button _newFeatureService;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feature_service_created);
		
		_ok = (Button)findViewById(R.id.btnOK);
		_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent returnIntent = new Intent();
	            setResult(RESULT_CANCELED,returnIntent);     
	            finish();
            };
       });
		
		_newFeatureService = (Button)findViewById(R.id.newFeatServiceButton);
		_newFeatureService.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent returnIntent = new Intent();
	            returnIntent.putExtra("CreateAnother", true);
	            setResult(RESULT_OK,returnIntent);     
	            finish();
            };
       });
	}
}
