package com.damithdev.jsonex;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.telecom.ConnectionRequest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.damithdev.jsonex.helper.ConnectionHelper;
import com.damithdev.jsonex.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passText;
    private Button logButton;

    private String emailString;
    private String passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        emailText = (EditText) findViewById(R.id.email);
        passText = (EditText) findViewById(R.id.pass);
        logButton = (Button) findViewById(R.id.logBtn);



        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailString = emailText.getText().toString();
                passString = passText.getText().toString();
                new LoginReq().execute();
            }
        });

    }

    public class LoginReq extends AsyncTask<String,Void,String>{
        String response = null;


        @Override
        protected String doInBackground(String... strings) {



            JSONObject postDataParams = new JSONObject();
            try {
                JSONObject jObj = new JSONObject();
                jObj.put("email",emailString);
                jObj.put("password",passString);
                postDataParams.put("operation", "login");
                postDataParams.put("user", jObj);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            String url = "http://10.10.21.171/android/index.php";
            try {

                JSONObject jsonObject = new JSONObject(ConnectionHelper.post(postDataParams,url));
                response=jsonObject.getString("result");


            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;

        }

        @Override
        protected void onPostExecute(String response) {
            /*super.onPostExecute(s);*/

            if (response.equals("success")){
                Toast.makeText(getApplicationContext(),response ,
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

            }


        }
    }
}
