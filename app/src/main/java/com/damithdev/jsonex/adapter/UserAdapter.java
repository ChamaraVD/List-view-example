package com.damithdev.jsonex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.damithdev.jsonex.R;
import com.damithdev.jsonex.model.Score;

import java.util.ArrayList;


/**
 * Created by Damith on 3/21/2017.
 */

public class UserAdapter extends ArrayAdapter<Score> {

    ArrayList<Score> arrayList = new ArrayList<>();

    public UserAdapter (Context context,int textViewResourceId,ArrayList<Score> objects){
        super(context, textViewResourceId, objects);
        arrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.item_user, null);
        TextView textView = (TextView) v.findViewById(R.id.tvName);
        TextView imageView = (TextView) v.findViewById(R.id.tvHome);

        textView.setText(arrayList.get(position).getId());
        imageView.setText(arrayList.get(position).getTitle());
        return v;
    }
}
