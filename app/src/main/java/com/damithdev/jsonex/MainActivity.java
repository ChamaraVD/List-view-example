package com.damithdev.jsonex;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.damithdev.jsonex.adapter.UserAdapter;
import com.damithdev.jsonex.helper.ConnectionHelper;
import com.damithdev.jsonex.model.Score;
import com.damithdev.jsonex.services.ScoreService;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Damith on 3/21/2017.
 */

public class MainActivity extends AppCompatActivity {

    private ArrayList<Score> newItems;
    private Activity mActivity;
    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTaskHelp().execute();

        simpleList = (ListView)findViewById(R.id.simpleListView);
    }

    private class AsyncTaskHelp extends AsyncTask<String,String,String>{


        @Override
        protected String doInBackground(String... strings) {



            try {

                newItems = ScoreService.getScore();

            }catch (JSONException e){

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            UserAdapter userAdapter = new UserAdapter(getApplicationContext(),R.layout.item_user,newItems);
            simpleList.setAdapter(userAdapter);
            //Log.e(s,"kmsk");
        }
    }


}
