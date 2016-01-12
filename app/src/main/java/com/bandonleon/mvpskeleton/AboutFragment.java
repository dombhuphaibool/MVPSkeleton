package com.bandonleon.mvpskeleton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dom on 1/11/16.
 *
 * Thin implmentation of the view. All Android dependencies goes here.
 */
public class AboutFragment extends MVPFragment implements AboutPresenter.AboutView {

    private TextView mBuildVersionTxt;

    @Override
    protected MVPPresenter createPresenter() {
        return new AboutPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        mBuildVersionTxt = (TextView) rootView.findViewById(R.id.build_version_txt);
        return rootView;
    }

    @Override
    public void setBuildVersion(String version) {
        mBuildVersionTxt.setText(version);
    }

    @Override
    public String getBuildVersionFromResource() {
        return getString(R.string.build_version);
    }
}
