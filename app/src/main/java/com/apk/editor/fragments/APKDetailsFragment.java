package com.apk.editor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apk.editor.R;
import com.apk.editor.adapters.APKDetailsAdapter;
import com.apk.editor.utils.ExternalAPKData;

import in.sunilpaulmathew.sCommon.CommonUtils.sExecutor;

/*
 * Created by APK Explorer & Editor <apkeditor@protonmail.com> on November 07, 2021
 */
public class APKDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.layout_recyclerview, container, false);

        RecyclerView mRecyclerView = mRootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        
        new sExecutor() {
            private APKDetailsAdapter mAdapter;
            @Override
            public void onPreExecute() {
            }

            @Override
            public void doInBackground() {
                mAdapter = new APKDetailsAdapter(ExternalAPKData.getData(requireActivity()));
            }

            @Override
            public void onPostExecute() {
                mRecyclerView.setAdapter(mAdapter);

            }
        }.execute();

        return mRootView;
    }
    
}