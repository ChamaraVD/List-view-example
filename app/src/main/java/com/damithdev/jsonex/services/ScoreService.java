package com.damithdev.jsonex.services;

import com.damithdev.jsonex.helper.ConnectionHelper;
import com.damithdev.jsonex.model.Score;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Damith on 3/5/2017.
 */

public class ScoreService {

    public static ArrayList<Score> getScore() throws JSONException,IOException {

        ArrayList<Score> items = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(ConnectionHelper.get("http://www.adaderana.lk/app_services/androidV2/LIVE/V2.0.0.1/android_news_service_main.php?lan=english&q=news&id=e5"));

        JSONArray jsonArray = jsonObject.getJSONArray("TopNewsGivenCat");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObj = jsonArray.getJSONObject(i);

            Score score = new Score(jsonObj.getString("id"),
                    jsonObj.getString("title")
                    );


            items.add(score);

        }

        return items;
    }


}
