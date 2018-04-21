package com.demo.csc214.socialmediaapp.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.csc214.socialmediaapp.R;

import java.io.File;

/**
 * Created by Sailesh on 4/20/18.
 */

public class ProfileDialogFragment extends DialogFragment {

    private static final String ARG_FIRSTNAME = "firstName";
    private static final String ARG_LASTNAME = "lastName";
    private static final String ARG_PROFILE = "profile_pic";
    private static final String ARG_HOMETOWN = "hometown";

    private static final String ARG_BIRTHDAY = "birthday";
    private static final String ARG_BIO = "bio";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.profile_description_layout, null);

        Bundle bundle = getArguments();

        String firstName = bundle.getString(ARG_FIRSTNAME);
        String lastName = bundle.getString(ARG_LASTNAME);
        String profilePic = bundle.getString(ARG_PROFILE);
        String hometown = bundle.getString(ARG_HOMETOWN);
        String birthday = bundle.getString(ARG_BIRTHDAY);
        String bio = bundle.getString(ARG_BIO);

        ImageView profilePicture = view.findViewById(R.id.image_dialog_profile);

        TextView firstText = view.findViewById(R.id.first_name_dialog_profile);
        TextView lastText = view.findViewById(R.id.last_name_dialog_profile);
        TextView hometownText = view.findViewById(R.id.hometown_name_dialog_profile);
        TextView bioText = view.findViewById(R.id.bio_dialog_profile_text);

        TextView birthdayText = view.findViewById(R.id.birthdate_name_dialog_profile);

        firstText.setText(firstName);
        lastText.setText(lastName);
        hometownText.setText(hometown);
        birthdayText.setText(birthday);
        bioText.setText(bio);


        File mPhotoFile;

        File picturesDir = getActivity().getApplication().getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        mPhotoFile = new File(picturesDir, profilePic);

        Bitmap photo = getScaledBitmap(mPhotoFile.getPath(), 150, 200);

        profilePicture.setImageBitmap(photo);

        profilePicture.setScaleType(ImageButton.ScaleType.CENTER_CROP);

        return new AlertDialog.Builder(getActivity()).setView(view).setTitle("Information").setPositiveButton("Done", null).create();


    }

    //Source: Lecture Slides
    public static Bitmap getScaledBitmap(String path, int width, int height) {
        BitmapFactory.Options options =
                new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;
        int sampleSize = 1;
        if(srcHeight > height || srcWidth > width ) {
            if(srcWidth > srcHeight) {
                sampleSize = Math.round(srcHeight / height);
            }
            else {
                sampleSize = Math.round(srcWidth / width);
            }
        }
        BitmapFactory.Options scaledOptions =
                new BitmapFactory.Options();
        scaledOptions.inSampleSize = sampleSize;

        return BitmapFactory.decodeFile(path, scaledOptions);
    }
}
