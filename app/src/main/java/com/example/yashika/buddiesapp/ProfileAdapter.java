package com.example.yashika.buddiesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileAdapter extends ArrayAdapter<Profile> {
    /**
     * Create a new {@link ProfileAdapter} object.
     *
     * @param context  is the current context (i.e. Activity) that the adapter is being created in.
     * @param profiles is the list of {@link Profile}s to be displayed.
     */
    public ProfileAdapter(Context context, ArrayList<Profile> profiles) {
        super(context, 0, profiles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_friends_screen, parent, false);
        }

        // Get the {@link Profile} object located at this position in the list
        Profile currentProfile = getItem(position);

        // Find the TextView in the activity_list.xml layout with the ID list_name.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_name);
        nameTextView.setText(currentProfile.getFriendName());

        // Find the TextView in the activity_list.xml layout with the ID list_description.
        TextView descTextView = (TextView) listItemView.findViewById(R.id.list_description);
        descTextView.setText(currentProfile.getFriendDesc());

        // Find the ImageView in the activity_list.xml layout with the ID list_image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_image);
        imageView.setImageResource(currentProfile.getImageResourceId());
        // Return the whole list item layout (containing 2 TextViews and 1 ImageView) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
