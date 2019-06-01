package com.dpk.githubtrendingrepositories;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dpk.githubtrendingrepositories.main.MainActivity;
import com.dpk.githubtrendingrepositories.main.MainInteractor;
import com.dpk.githubtrendingrepositories.main.MainMvpView;
import com.dpk.githubtrendingrepositories.main.MainPresenter;
import com.dpk.githubtrendingrepositories.model.Repo;
import com.dpk.githubtrendingrepositories.model.RepoDetails;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    private static final String TAG = "EspressoTest";

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testShowRepo() {
        Repo[] repos = new Repo[]{new Repo("testUsername", "testName", "testType", "testUrl", "https://google.com", new RepoDetails("testRepoName", "testDescription", "testUrl"))};
        MainMvpView mainMvpView = Mockito.mock(MainMvpView.class);
        MainPresenter mainPresenter = new MainPresenter(mainMvpView, new MainInteractor());
        mainPresenter.loadTestData(repos);
        Mockito.verify(mainMvpView, Mockito.atLeastOnce()).showRepoList(repos);
    }

}
