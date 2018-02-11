package com.austin.android.alexa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {
    public final static String TAG = "Alexa/AboutActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.about, container, false);
    }

    @Override
    public void onViewCreated(final View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        if (getActivity() instanceof AppCompatActivity)
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Alexa " + BuildConfig.VERSION_NAME);
    }
}
