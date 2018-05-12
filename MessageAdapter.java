package com.google.firebase.udacity.friendlychat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;

import java.util.List;

import static com.google.firebase.udacity.friendlychat.R.id.mem_menu;
import static com.google.firebase.udacity.friendlychat.R.id.videoView;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {
    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        ListView usersList=(ListView)convertView.findViewById(R.id.usersList);
        TextView noUsersText=(TextView)convertView.findViewById(R.id.noUsersText);
        VideoView videoView1=(VideoView) convertView.findViewById(R.id.videoView);




        FriendlyMessage message = getItem(position);
        int totalUsers=0;
        if(totalUsers<=1){
            noUsersText.setVisibility(View.VISIBLE);
            usersList.setVisibility(View.GONE);
        }
        else{
            noUsersText.setVisibility(View.GONE);
            usersList.setVisibility(View.VISIBLE);
          //  usersList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,));
        }
        boolean isVideo=message.getVideoUrl()!=null;
        if(isVideo){
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.GONE);
            videoView1.setVisibility(View.VISIBLE);
        }
        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());

        return convertView;
    }
}
