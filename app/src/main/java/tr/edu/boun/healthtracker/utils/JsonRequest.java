package tr.edu.boun.healthtracker.utils;

import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import tr.edu.boun.healthtracker.model.FoodReportModel;
import tr.edu.boun.healthtracker.model.ListJsonModel;
import tr.edu.boun.healthtracker.model.SearchModel;
import tr.edu.boun.healthtracker.model.inner.FoodObject;
import tr.edu.boun.healthtracker.model.inner.ListItemObject;
import tr.edu.boun.healthtracker.model.inner.SearchItemObject;

/**
 * Created by haluks on 06/12/2016.
 */

public class JsonRequest
{
    private HttpClient service;
    private String apiUri = "http://ec2-54-186-174-174.us-west-2.compute.amazonaws.com:8000/";

    public JsonRequest() {

        HttpParams httpParameters = new BasicHttpParams();
        int timeoutConnection = 30 * 1000;
        HttpConnectionParams.setConnectionTimeout(httpParameters,
                timeoutConnection);
        int timeoutSocket = 1 * 60 * 1000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
        service = new DefaultHttpClient(httpParameters);

    }

    public String sendRequest(String uri) {
        try {
            // HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(uri));
            HttpResponse response = service.execute(request);
            InputStream ips = response.getEntity().getContent();
            BufferedReader buf = new BufferedReader(new InputStreamReader(ips,
                    "UTF-8"));

            StringBuilder sb = new StringBuilder();
            String s;
            while (true) {
                s = buf.readLine();
                if (s == null || s.length() == 0)
                    break;
                sb.append(s);

            }
            buf.close();
            ips.close();
            String jsonString = sb.toString();

            return jsonString;
        } catch (Exception e) {
            return "{ 'Error':[{ 'Message' : '', 'No': -404}]}";

        }
    }

    /*
        implementation
     */

    public List<ListItemObject> sendRequestList(String type, String sort) {

        String uri = apiUri + "list?format=json";
        uri += "&lt=" + type;
        uri += "&sort=" + sort;

        String jsonString = sendRequest(uri);

        List<ListItemObject> retList = new ArrayList<>();

        try {

            Gson gson = new Gson();
            ListJsonModel objects = gson.fromJson(jsonString, ListJsonModel.class);

            if (objects.getList() != null) {

                return objects.getList().getItem();
            } else {
                Log.d("DEBUG: ", "EMPTY: " + jsonString);
                return retList;
            }

        } catch(Exception e) {
            Log.d("DEBUG: ", "ERROR: " + jsonString);
            return retList;
        }
    }

    public FoodObject sendRequestFoodReport(String ndbno, String type) {

        String uri = apiUri + "foodreport?ndbno=" + ndbno;
        uri += "&type=" + type;

        String jsonString = sendRequest(uri);

        FoodObject ret = new FoodObject();

        try {

            Gson gson = new Gson();
            FoodReportModel model = gson.fromJson(jsonString, FoodReportModel.class);

            if (model.getReport() != null) {

                return model.getReport().getFood();
            } else {
                Log.d("DEBUG: ", "EMPTY: " + jsonString);
                return ret;
            }
        } catch(Exception e) {
            Log.d("DEBUG: ", "ERROR: " + jsonString);
            return ret;
        }
    }

    public List<SearchItemObject> sendRequestSearch(String query, String sort) {

        String uri = apiUri + "search?q=";

        try
        {
            uri += URLEncoder.encode(query, "UTF-8");
        } catch(UnsupportedEncodingException e)
        {
            uri += query;
        }

        uri += "&sort=" + sort;

        String jsonString = sendRequest(uri);

        List<SearchItemObject> retList = new ArrayList<>();

        try {

            Gson gson = new Gson();
            SearchModel model = gson.fromJson(jsonString, SearchModel.class);

            if (model.getList() != null) {

                return model.getList().getItem();
            } else {
                Log.d("DEBUG: ", "EMPTY: " + jsonString);
                return retList;
            }
        } catch(Exception e) {
            Log.d("DEBUG: ", "ERROR: " + jsonString);
            return retList;
        }

    }
}
