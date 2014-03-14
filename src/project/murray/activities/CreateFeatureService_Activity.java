package project.murray.activities;

import project.murray.R;
import project.murray.json.FeatureServiceCreationError;
import project.murray.json.FeatureServiceCreationSuccess;
import project.murray.online.AddDefinition;
import project.murray.online.AdminLayerInfoAttribute;
import project.murray.online.Attributes;
import project.murray.online.CreateFeatureServiceObjectParameters;
import project.murray.online.DefinitionLayer;
import project.murray.online.DrawingInfo;
import project.murray.online.EditorTrackingInfo;
import project.murray.online.Extent;
import project.murray.online.GeometryField;
import project.murray.online.HttpWebRequestHelper;
import project.murray.online.Index;
import project.murray.online.PointSymbol;
import project.murray.online.Prototype;
import project.murray.online.Renderer;
import project.murray.online.SpatialReference;
import project.murray.online.Table;
import project.murray.online.Template;
import project.murray.online.XssPreventionInfo;
import project.murray.online.Field;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class CreateFeatureService_Activity extends Activity {
	AddDefinition definition;
	Boolean _testBoolean;
	String token;
	String organizationEndPoint;
	String organizationID;
	String featureServiceName;
	String addAttributionResponse;
	String requestURL;
	String _createFeatureServiceJSONReturn;
	String _dataType;
	String fieldAttribution;
	String[] _sqlTypes = new String[] { "sqlTypeNVarchar", "sqlTypeInteger",
			"sqlTypeOther", "sqlTypeFloat" };
	String _sqlType;

	Thread _thread;

	Button _buttonAdd;
	Button _buttonSave;
	Button _buttonCancel;
	Button _buttonInteger;
	Button _buttonDate;
	Button _buttonString;

	EditText _fieldName;
	EditText _fieldalias;

	ProgressBar _progress;

	FeatureServiceCreationSuccess _featureService;
	HttpWebRequestHelper _requestHelper;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_fields);

		try {
			Bundle extras = getIntent().getExtras();
			if (extras != null) {
				token = extras.getString("Token");
				organizationEndPoint = extras.getString("OrgEndPoint");
				featureServiceName = extras.getString("FeatureServiceName");
			}
		} catch (Exception e) {
		}

		_featureService = null;

		_buttonInteger = (Button) findViewById(R.id.integerButton);
		_buttonInteger.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				_dataType = "integer";
				_sqlType = _sqlTypes[1];
			}
		});

		_buttonDate = (Button) findViewById(R.id.dateButton);
		_buttonDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				_dataType = "datetime";
				_sqlType = _sqlTypes[2];
			}
		});

		_buttonString = (Button) findViewById(R.id.stringButton);
		_buttonString.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				_dataType = "text";
				_sqlType = _sqlTypes[0];
			}
		});

		// CANCEL
		_buttonCancel = (Button) findViewById(R.id.createFieldsCancelButton);
		_buttonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent returnIntent = new Intent();
				setResult(RESULT_CANCELED, returnIntent);
				finish();
			}
		});

		// ADD
		_buttonAdd = (Button) findViewById(R.id.createFieldsAddButton);
		_buttonAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String fieldName = null;
				String alias = null;
				String empty = "";

				fieldName = ((EditText) findViewById(R.id.editTextFieldName))
						.getText().toString();
				((EditText) findViewById(R.id.editTextFieldName))
						.setText(empty);
				((EditText) findViewById(R.id.editTextFieldName))
						.requestFocus();
				alias = ((EditText) findViewById(R.id.editTextAlias)).getText()
						.toString();
				((EditText) findViewById(R.id.editTextAlias)).setText(empty);

				fieldAttribution += "@" + fieldName + "," + alias + ","
						+ _dataType + "," + _sqlType;
			}
		});

		// CREATE
		_buttonSave = (Button) findViewById(R.id.createFieldsSaveButton);
		_buttonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				_buttonSave.setEnabled(false);

				final ProgressDialog dialog = new ProgressDialog(
						CreateFeatureService_Activity.this);
				dialog.setMessage("Project Murray is thinking...");
				dialog.setIndeterminate(true);
				dialog.setCancelable(false);
				dialog.show();

				new AsyncTask<Void, Void, Void>() {
					@Override
					protected Void doInBackground(Void... params) {
						try {
							// POST CALL
							final String serialized = FeatureServiceObjectSerialized(featureServiceName);
							_createFeatureServiceJSONReturn = HttpWebRequestHelper
									.CreateFeatureService(
											"https://startups.maps.arcgis.com/sharing/content/users/edan/createService?f=json&token="
													+ token, serialized);

							String serviceEndPoint = "https://services.arcgis.com/";

							// TODO: Pass this value in. Developers, you will
							// need to alter this for the orgID you are hitting.
							organizationID = "q7zPNeKmTWeh7Aor";

							requestURL = String
									.format("%1$s%2$s/arcgis/admin/services/%3$s.FeatureServer/AddToDefinition",
											serviceEndPoint, organizationID,
											featureServiceName);
							definition = CreateFeatureService();
							addAttributionResponse = AddToFeatureServiceDefinition(
									requestURL, definition);
						} catch (Exception e) {

							e.printStackTrace();
						}
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						try {
							dialog.dismiss();
							if (_createFeatureServiceJSONReturn != null) {
								FeatureServiceCreationError error = null;
								_buttonAdd.setEnabled(false);
								try {
									error = new FeatureServiceCreationError(
											_createFeatureServiceJSONReturn);
								} catch (Exception exc) {
								}

								try {
									_featureService = new FeatureServiceCreationSuccess(
											_createFeatureServiceJSONReturn);
								} catch (Exception eee) {
								}

								if (_featureService != null) {
									Intent returnIntent = new Intent();
									returnIntent.putExtra("CreationSuccess",
											true);
									setResult(RESULT_OK, returnIntent);
									finish();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							dialog.dismiss();
						}
					}
				}.execute();
			}
		});
	}

	private String FeatureServiceObjectSerialized(String featureServiceName) {
		// request string
		CreateFeatureServiceObjectParameters createFeatServObjParams = new CreateFeatureServiceObjectParameters();
		createFeatServObjParams.currentVersion = 10.11;
		createFeatServObjParams.serviceDescription = "";
		createFeatServObjParams.hasVersionedData = false;
		createFeatServObjParams.supportsDisconnectedEditing = false;
		createFeatServObjParams.hasStaticData = false;
		createFeatServObjParams.maxRecordCount = 2000;
		createFeatServObjParams.supportedQueryFormats = "JSON";
		createFeatServObjParams.capabilities = "Query,Editing,Create,Update,Delete";
		createFeatServObjParams.description = "";
		createFeatServObjParams.copyrightText = "";
		createFeatServObjParams.allowGeometryUpdates = true;
		createFeatServObjParams.units = "esriMeters"; // TODO: create an enum
														// representation of
														// values
		createFeatServObjParams.syncEnabled = false;

		createFeatServObjParams.editorTrackingInfo = new EditorTrackingInfo(
				false, false, true, true);
		createFeatServObjParams.editorTrackingInfo.enableEditorTracking(false);// =
																				// false;
		createFeatServObjParams.editorTrackingInfo
				.enableOwnershipAccessControl(false);
		createFeatServObjParams.editorTrackingInfo.allowOthersToUpdate(true);
		createFeatServObjParams.editorTrackingInfo.allowOthersToDelete(true);

		createFeatServObjParams.xssPreventionInfo = new XssPreventionInfo();
		createFeatServObjParams.xssPreventionInfo.xssPreventionEnabled = true;
		createFeatServObjParams.xssPreventionInfo.xssPreventionRule = "InputOnly"; // TODO:
																					// create
																					// an
																					// enum
																					// representation
																					// of
																					// values
		createFeatServObjParams.xssPreventionInfo.xssInputRule = "rejectInvalid";

		createFeatServObjParams.tables = new Table[] {}; // TODO: test if this
															// can be omitted as
															// this is simply
															// creating an empty
															// collection
		createFeatServObjParams.name = featureServiceName;

		String serializedObject = null;
		Gson gson = new Gson();
		serializedObject = gson.toJson(createFeatServObjParams);

		String featureServiceInfoString = "createParameters="
				+ serializedObject
				+ "&targetType=featureService&f=pjson&token=" + token;

		return featureServiceInfoString;
	}

	private AddDefinition CreateFeatureService() {
		DefinitionLayer DefLayer = null;
		if (fieldAttribution != null) {
			if (!fieldAttribution.isEmpty()) {
				Extent extent = null;
				PointSymbol symbol = null;
				Renderer renderer = null;
				DrawingInfo drawingInfo = null;
				Template template = null;
				AdminLayerInfoAttribute adminLayerInfo = null;

				extent = new Extent(-6199999.999999896, -14999999.999999743,
						7841397.327701188, 1859754.5323447795,
						new SpatialReference(102100, 3857));

				symbol = new PointSymbol();
				symbol.type("esriPMS");
				symbol.url("http://static.arcgis.com/images/Symbols/Basic/RedSphere.png");
				symbol.imageData("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");
				symbol.contentType("image/png");
				symbol.width(15);
				symbol.height(15);
				symbol.angle(0);
				symbol.xoffset(0);
				symbol.yoffset(0);

				renderer = new Renderer();
				renderer.type("simple");
				renderer.symbol(symbol);
				renderer.label("");
				renderer.description("");

				drawingInfo = new DrawingInfo();
				drawingInfo.renderer(renderer);
				drawingInfo.labelingInfo(null);

				String[] split = fieldAttribution.split("@");
				String[] fldSplit = null;
				Field[] fields1 = new Field[split.length];// first element is
															// empty, but we
															// need one extra to
															// account for FID

				// DO NOT CHANGE PROPERTIES BELOW
				Field fieldFID1 = new Field();
				fieldFID1.setName("FID");
				fieldFID1.setType("esriFieldTypeInteger");
				fieldFID1.setAlias("FID");
				fieldFID1.setSqlType("sqlTypeInteger");
				fieldFID1.setIsNullable(false);
				fieldFID1.setEditable(false);
				fieldFID1.Domain(null);
				fieldFID1.DefaultValue(null);

				fields1[0] = fieldFID1;

				for (int i = 1; i < split.length; i++) {
					fldSplit = split[i].split(",");
					Field field = new Field();
					field.setName(fldSplit[0]);
					field.setAlias(fldSplit[1]);
					field.setType(fldSplit[2]);
					field.setSqlType(fldSplit[3]);
					field.setIsNullable(true);
					field.setEditable(true);
					field.Domain(null);
					field.DefaultValue(null);
					fields1[i] = field;
				}

				Prototype proType = new Prototype(new Attributes());
				template = new Template("New Feature", "",
						"esriFeatureEditToolPoint", proType);

				Template[] templates = { template };
				Index index = new Index("index1", "FID", false, false, "index1");
				Index[] indexes = { index };

				GeometryField geometryField = new GeometryField("Shape", 102100);

				adminLayerInfo = new AdminLayerInfoAttribute(geometryField);

				DefLayer = new DefinitionLayer();
				DefLayer.Indexes(indexes);
				DefLayer.currentVersion(10.11);
				DefLayer.id(0);
				DefLayer.name(featureServiceName);
				DefLayer.type("Feature Layer");
				DefLayer.displayField("");
				DefLayer.description("");
				DefLayer.copyrightText("");
				DefLayer.defaultVisibility(true);
				DefLayer.relationships(null);
				DefLayer.isDataVersioned(false);
				DefLayer.supportsRollbackOnFailureParameter(true);
				DefLayer.supportsAdvancedQueries(true);
				DefLayer.geometryType("esriGeometryPoint");
				DefLayer.minScale(0);
				DefLayer.maxScale(0);
				DefLayer.extent(extent);
				DefLayer.drawingInfo(drawingInfo);
				DefLayer.allowGeometryUpdates(true);
				DefLayer.hasAttachments(false);
				DefLayer.htmlPopupType("esriServerHTMLPopupTypeNone");
				DefLayer.hasM(false);
				DefLayer.hasZ(false);
				DefLayer.objectIdField("FID");
				DefLayer.globalIdField("");
				DefLayer.typeIdField("");
				DefLayer.fields(fields1);
				DefLayer.types(new Object[0]);
				DefLayer.templates(templates);
				DefLayer.supportedQueryFormats("JSON");
				DefLayer.hasStaticData(false);
				DefLayer.maxRecordCount(2000);
				DefLayer.capabilities("Query,Editing,Create,Update,Delete");
				DefLayer.adminLayerInfo(adminLayerInfo);
			}
			;

			DefinitionLayer[] layers = new DefinitionLayer[] { DefLayer };
			definition = new AddDefinition(layers);
			return definition;
		}
		return null;
	}

	private String AddToFeatureServiceDefinition(String url,
			AddDefinition definition) {
		String serializedObject = null;
		Gson gson = new GsonBuilder().serializeNulls().create();
		serializedObject = gson.toJson(definition);
		String response = "";

		String addToDefinition = "addToDefinition=" + serializedObject
				+ "&f=pjson&token=" + token;
		try {
			response = HttpWebRequestHelper.AddDefinitionToFeatureService(url,
					addToDefinition);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
}
