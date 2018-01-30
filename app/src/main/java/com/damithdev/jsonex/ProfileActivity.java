package com.damithdev.jsonex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.damithdev.jsonex.model.Score;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView addTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameTextView = (TextView) findViewById(R.id.name_id);
        addTextView = (TextView) findViewById(R.id.address_id);

        Score score = (Score) getIntent().getExtras().get("position");
        nameTextView.setText(score.getType());
        addTextView.setText(score.getTitle());


    }
}
