package project.murray.activities;

import project.murray.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeatureServiceName extends Activity {
	Button _nextButton;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feature_service_name);
		
		_nextButton = (Button)findViewById(R.id.nextButton);
		_nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
				final String featureServiceName = ((EditText)findViewById(R.id.textEditFeatureServiceName)).getText().toString();
                if(featureServiceName != null){
            	Intent returnIntent = new Intent();
	            returnIntent.putExtra("FeatureServiceName", featureServiceName);
	            setResult(RESULT_OK,returnIntent);     
	            finish();
                }
            };
       });
	}
}
