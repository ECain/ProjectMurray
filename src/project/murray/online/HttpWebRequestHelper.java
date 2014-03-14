package project.murray.online;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import project.murray.json.NameIsAvailable;
import project.murray.json.Token;

public class HttpWebRequestHelper {

	private final static String USER_AGENT = "Mozilla/5.0";
	private final static String ARCGIS_SELF = "http://www.arcgis.com/sharing/rest/community/self?f=pjson&token=";
	private final static String ARCGIS_TOKEN = "https://www.arcgis.com/sharing/generatetoken?f=json";
	private final static String ARCGIS_MYCONTENT = "http://services.arcgis.com/";
	private final static String ARCGIS_MYCONTENT2 = "/ArcGIS/rest/services/";

	public static String GetToken(String[] args) throws Exception {
		HttpWebRequestHelper helper = new HttpWebRequestHelper();

		if(!args[2].endsWith("/"))
			args[2] = args[2] + "/";
		
		String urlParameters = "username="
				+ args[0]
				+ "&password="
				+ args[1]
				+ "&expiration=120&referer="  //2 hours
				+ args[2]
				+ "&f=pjson";
		return Token.GetToken(helper.sendPostHttps(ARCGIS_TOKEN, urlParameters));
	}

	public static String GetSelf(String[] args) throws Exception {
		HttpWebRequestHelper helper = new HttpWebRequestHelper();
		if (args.length == 1) {
			return helper.sendGet(ARCGIS_SELF + args[0], "");
		}
		return null;
	}

	public static String Get_My_Organisation_Content(String organisationId,
			String token) throws Exception {
		// this is a GET call
		HttpWebRequestHelper helper = new HttpWebRequestHelper();
		String baseUrl = ARCGIS_MYCONTENT + organisationId + ARCGIS_MYCONTENT2;
		String completeUrl = baseUrl + "?f=pjson&token=" + token;

		return helper.sendGet(completeUrl, "");
	}

	public static boolean IsFeatureServiceNameAvailable(
			String featureServiceName, String organizationEndPoint, String token)
			throws Exception {
		HttpWebRequestHelper helper = new HttpWebRequestHelper();
		String url = organizationEndPoint + "/isServiceNameAvailable?name="
				+ featureServiceName + "&type=Feature_Service&f=json&token="
				+ token;
		return NameIsAvailable.IsAvailable(helper.sendGet(url, ""));
	}

	public static String CreateFeatureService(String url, String parameters)
			throws Exception {
		HttpWebRequestHelper helper = new HttpWebRequestHelper();
		return helper.sendPostHttps(url, parameters);
	}
	
	public static String AddDefinitionToFeatureService(String url, String definition)
			throws Exception{
		HttpWebRequestHelper helper = new HttpWebRequestHelper();
		String response = helper.sendPostHttps(url, definition);
		return response;
	}

	// HTTP GET request
	private String sendGet(String url, String urlParameters) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) obj
				.openConnection();

		// optional default is GET
		httpConnection.setRequestMethod("GET");

		// add request header
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
		} catch (Exception e) {
			
		}

		if (in == null)
			return "";

		String inputLine;

		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

	// HTTP POST request
	@SuppressWarnings("deprecation")
	private String sendPost(String url, String urlParameters) throws Exception {
		URL uri = new URL(url);

		HttpsURLConnection httpConnection = (HttpsURLConnection) uri
				.openConnection();
		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);
		httpConnection.setUseCaches(false);
		// add request header
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		httpConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		httpConnection.setRequestProperty("ContentType",
				"application/x-www-form-urlencoded");

		try {
			// Send post request
			DataOutputStream wr = new DataOutputStream(
					httpConnection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			String result = null;

			DataInputStream inStream = new DataInputStream(
					httpConnection.getInputStream());
			if (inStream != null) {
				result = inStream.readLine();
			}
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// HTTP POST request
	private String sendPostHttps(String url, String urlParameters)
			throws Exception {
		URL uri = new URL(url);

		HttpsURLConnection httpConnection = (HttpsURLConnection) uri.openConnection();

		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);
		httpConnection.setUseCaches(false);
		// add request header
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		httpConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		httpConnection.setRequestProperty("ContentType",
				"application/x-www-form-urlencoded");

		try {
			// Send post request
			DataOutputStream wr = new DataOutputStream(
					httpConnection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			String result = null;

				BufferedReader in = new BufferedReader(new InputStreamReader(
						httpConnection.getInputStream()));
				
				if (in != null) {
					String inputLine;

					StringBuilder response = new StringBuilder();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
				
					in.close();

					result = response.toString();
				}
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
