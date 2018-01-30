package com.damithdev.jsonex.helper;

import android.app.Activity;

import com.damithdev.jsonex.exception.NoInternetException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Damith on 3/5/2017.
 */

public class ConnectionHelper {

    public static String get(String url) throws IOException, JSONException {

        URL obj = new URL(DataHelper.urlEncoder(url));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        int responseCode = 0;

        try {

            responseCode = con.getResponseCode();

        } catch (IOException ioEx) {

            if (ioEx.getMessage().contains("Network is unreachable")) {  // Throws NoInternetException

                throw new NoInternetException("No Internet");

            } else if (ioEx.getMessage().contains("No valid pins found")) { // handle pin validation
                // savePin(activity);
                throw new IOException();
            } else if (ioEx.getMessage().contains("Could not validate certificate")) { // Pin Expire
                // savePin(activity);
                throw new IOException();
            } else {  // Throw IOException

                throw new IOException();
            }
        }

        if (responseCode == 200) {

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();

        } else {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("response", responseCode);
            jsonObject.put("message", "error");


            return jsonObject.toString();

        }


    }

    public static String post(JSONObject json, String url) throws IOException, JSONException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //HttpsURLConnection con = getConnection(activity, url);

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");


        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(json.toString());
        wr.flush();
        wr.close();

        int responseCode = 0;

        try {

            responseCode = con.getResponseCode();

        } catch (IOException ioEx) {

            if (ioEx.getMessage().contains("Network is unreachable")) {  // Throws NoInternetException

                throw new NoInternetException("No Internet");

            } else {  // Throw IOException

                throw new IOException();
            }
        }
        if (responseCode == 200 || responseCode == 500) {

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();

        } else if (responseCode == 417) {

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();

        } else {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("response", responseCode);
            jsonObject.put("message", "error");


            return jsonObject.toString();
        }


    }


}
