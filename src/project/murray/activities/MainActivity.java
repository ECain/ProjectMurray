package project.murray.activities;

import project.murray.R;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button _newFeatureService;
	Button _learnMore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		_newFeatureService = (Button)findViewById(R.id.newFeatureService);
		
		_newFeatureService.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent welcome = new Intent(MainActivity.this, Welcome.class);
				startActivityForResult(welcome, 1);
           	};
		});
		
		_learnMore = (Button)findViewById(R.id.learnMoreButton);
		_learnMore.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
					String url = "http://www.arcgis.com";
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(browserIntent);
           	};
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_CANCELED) {
			finish();
		}
	}

}
