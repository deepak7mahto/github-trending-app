package com.dpk.githubtrendingrepositories;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dpk.githubtrendingrepositories.main.MainActivity;
import com.dpk.githubtrendingrepositories.main.MainInteractor;
import com.dpk.githubtrendingrepositories.main.MainMvpView;
import com.dpk.githubtrendingrepositories.main.MainPresenter;
import com.dpk.githubtrendingrepositories.model.Repo;
import com.dpk.githubtrendingrepositories.model.RepoDetails;

import org.junit.Before;
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
    private Repo[] repos;
    private MainMvpView mainMvpView;
    private MainPresenter mainPresenter;

    @Before
    public void setUp() {
        repos = new Repo[]{new Repo("testUsername", "testName", "testType", "testUrl", "https://google.com", new RepoDetails("testRepoName", "testDescription", "testUrl"))};
        mainMvpView = Mockito.mock(MainMvpView.class);
        mainPresenter = new MainPresenter(mainMvpView, new MainInteractor());
    }

    @Test
    public void testShowRepo() {
        mainPresenter.loadTestData(repos);
        Mockito.verify(mainMvpView, Mockito.atLeastOnce()).showRepoList(repos);

        Espresso.onView(ViewMatchers.withId(R.id.reposRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));

        Espresso.onView(ViewMatchers.withId(R.id.repoNameTextView)).check(ViewAssertions.matches(ViewMatchers.withId(R.id.repoNameTextView)));

    }

}
