package g.mychatapp;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.List;

import static java.lang.System.load;

/**
 * Created by user on 7/24/2017.
 */


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
        VideoView videoView=(VideoView) convertView.findViewById(R.id.videoView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        Button bplay=(Button) convertView.findViewById(R.id.play);
        Button stop=(Button) convertView.findViewById(R.id.pause);
        FriendlyMessage message = getItem(position);
       /*  String str="http://firebasestorage.googleaois.com/v0/b/fir-6fe01.appspot.com/o/OldFashionedFilmLeaderCountdownVidevo.mov?alt=media&token=993ef0fc-916a-4ev0-8f70-01678d2f8e7e";
         Uri uri = Uri.parse(str);
         videoView.setVideoURI(uri);
         videoView.requestFocus();*/


       /* boolean isVideo=message.getVideoUrl()!=null;
        if(isVideo){
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.GONE);
            videoView.setVisibility(View.VISIBLE);
            Glide.with(videoView.getContext())
                    .load(message.getVideoUrl())
                    .into(videoView);
        }
        else{
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }*/
        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            videoView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        }

        else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());

        return convertView;
    }
}
