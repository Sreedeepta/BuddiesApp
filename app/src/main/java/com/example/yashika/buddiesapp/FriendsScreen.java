package com.example.yashika.buddiesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Creating an ArrayList for Songs
        final ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(getString(R.string.name1), getString(R.string.desc1), R.drawable.akshit));
        profiles.add(new Profile(getString(R.string.name2), getString(R.string.desc2), R.drawable.geetanjali));
        profiles.add(new Profile(getString(R.string.name3), getString(R.string.desc3), R.drawable.karthikeyan));
        profiles.add(new Profile(getString(R.string.name4), getString(R.string.desc4), R.drawable.lakshit));


        // Create an {@link ProfileAdapter}, whose data source is a list of {@link Profile}s. The
        // adapter knows how to create list items for each item in the list.
        ProfileAdapter adapter = new ProfileAdapter(FriendsScreen.this, profiles);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list_view, which is declared in the
        // activity_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link ProfileAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Profile} in the list.
        listView.setAdapter(adapter);
    }
}
