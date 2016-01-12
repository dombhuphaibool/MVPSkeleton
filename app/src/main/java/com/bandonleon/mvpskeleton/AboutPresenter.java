package com.bandonleon.mvpskeleton;

/**
 * Created by dom on 1/11/16.
 *
 * Business logic goes here and can be unit tested without any Android dependencies.
 * All you need is the JVM.
 *
 * To perform screenshots, this AboutPresenter can be mocked out by Mockito and populate
 * the UI with mocked data as necessary.
 */
public class AboutPresenter extends MVPPresenter {

    // This view can be mocked for unit testing
    public interface AboutView {
        void setBuildVersion(String version);
        String getBuildVersionFromResource();
    }

    private AboutView mView;

    public AboutPresenter(AboutView view) {
        mView = view;
    }

    @Override
    public void onViewStart() {
        super.onViewStart();

        String buildVersion = mView.getBuildVersionFromResource();
        mView.setBuildVersion(buildVersion);
    }
}
