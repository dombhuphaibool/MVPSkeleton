package com.bandonleon.mvpskeleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class AboutPresenterTest {
    @Test
    public void testPresenter() throws Exception {
        AboutPresenter aboutPresenter = new AboutPresenter(new AboutPresenter.AboutView() {
            @Override
            public void setBuildVersion(String version) {}

            @Override
            public String getBuildVersionFromResource() {
                return "2.3.4";
            }
        });

        aboutPresenter.onViewStart();
    }
}