package com.bandonleon.mvpskeleton;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by dom on 1/11/16.
 */
public abstract class MVPFragment extends Fragment {

    private MVPPresenter mPresenter;

    protected abstract MVPPresenter createPresenter();

    public void setPresenter(MVPPresenter presenter) {
        if (BuildConfig.DEBUG) {
            mPresenter = presenter;
        } else {
            throw new IllegalStateException("Setting a presenter in RELEASE mode is not allowed!");
        }
    }

    protected <T extends MVPPresenter> T getPresenterAs(Class<T> type) {
        return type.cast(mPresenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
    }

    @Override
    public void onDestroy() {
        mPresenter = null;

        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();

        if (mPresenter != null) {
            mPresenter.onViewStart();
        }
    }

    @Override
    public void onStop() {
        if (mPresenter != null) {
            mPresenter.onViewStop();
        }

        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mPresenter != null) {
            mPresenter.onViewResume();
        }
    }

    @Override
    public void onPause() {
        if (mPresenter != null) {
            mPresenter.onViewPause();
        }

        super.onPause();
    }
}
