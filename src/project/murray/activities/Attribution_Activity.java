package project.murray.activities;

import project.murray.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Attribution_Activity extends Activity {
	ListView _listView;
	EditText _editText;
	EditText _editText2;
	Button _addButton;
	Button _saveButton;
	Button _cancelButton;
	Button _intButton;
	Button _stringButton;
	Button _dateButton;
	String _item = "String";
	String _attribution = "";
	String _attributionForSplit = "";
	TextView _textView;
	String _sqlType;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_fields);
			
		_addButton = (Button)findViewById(R.id.createFieldsAddButton);
		_addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String fieldName = null;	
            	String alias = null;
            	String dataType = null;
            	String empty = "";
            	
            	fieldName = ((EditText)findViewById(R.id.editTextFieldName)).getText().toString();
            	((EditText)findViewById(R.id.editTextFieldName)).setText(empty);
            	((EditText)findViewById(R.id.editTextFieldName)).requestFocus();
            	alias = ((EditText)findViewById(R.id.editTextAlias)).getText().toString();
            	((EditText)findViewById(R.id.editTextAlias)).setText(empty);
            	dataType = _item;
            	
            	_attributionForSplit += "@" + fieldName + "," + alias + "," + dataType + "," + _sqlType;
            }
        });
		
		_saveButton = (Button)findViewById(R.id.createFieldsSaveButton);	    
		_saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Toast.makeText(Attribution_Activity.this, _attribution, Toast.LENGTH_LONG).show(); 
            	Intent returnIntent = new Intent();
	            returnIntent.putExtra("attributionFields", _attributionForSplit);
	            setResult(RESULT_OK,returnIntent);     
	            finish();
            }
        });
	    
	    _cancelButton = (Button)findViewById(R.id.createFieldsCancelButton);
	    _cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent returnIntent = new Intent();
	            setResult(RESULT_CANCELED,returnIntent);     
	            finish();
            }
        });

	    _intButton = (Button)findViewById(R.id.integerButton);
	    _intButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	_sqlType = "esriFieldTypeInteger";
            }
        });
	    
		_stringButton = (Button)findViewById(R.id.stringButton);
		_stringButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	_sqlType = "esriFieldTypeString";
            }
        });
		
		_dateButton = (Button)findViewById(R.id.dateButton);
		_dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	_sqlType = "esriFieldTypeDate";
            }
        });
	}
}




