package com.example.alper.pawmate3;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {

    private final ArrayList<String> useremail;
    private final ArrayList<String> userImage;
    private final ArrayList<String> species;
    private final ArrayList<String> sex;
    private final Activity context;
    StorageReference storageReference;


    public PostClass(ArrayList<String> useremail, ArrayList<String> userImage, ArrayList<String> species, ArrayList<String> sex, Activity context) {
        super(context,R.layout.custom_view,useremail);
        this.useremail = useremail;
        this.userImage = userImage;
        this.species = species;
        this.sex = sex;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        TextView useremailText = customView.findViewById(R.id.postUsernameText);
        TextView speciesText = customView.findViewById(R.id.postSpeciesText);
        TextView sexText = customView.findViewById(R.id.postSexText);
        ImageView imageView = customView.findViewById(R.id.postImage);

        useremailText.setText(useremail.get(position));
        speciesText.setText(species.get(position));
        sexText.setText(sex.get(position));

        Picasso.get().load(userImage.get(position)).into(imageView);


        return customView;
    }
}
