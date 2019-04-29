package me.xdd.self.criminalintent.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;

import me.xdd.self.criminalintent.R;
import me.xdd.self.criminalintent.utils.PictureUtils;

public class PhotoDetailFragment extends DialogFragment {
    private static final String ARG_FILE = "file";
    private ImageView mPhotoView;

    public static PhotoDetailFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FILE, file);
        PhotoDetailFragment fragment = new PhotoDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo,null);
        File file = (File) getArguments().getSerializable(ARG_FILE);
        mPhotoView = view.findViewById(R.id.crime_photo_details);
        Bitmap bitmap = PictureUtils.getScaleBitmap(file.getPath(),getActivity());
        mPhotoView.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton(getResources().getString(R.string.ok),null)
                .create();
    }
}
