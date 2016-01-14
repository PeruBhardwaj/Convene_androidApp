package google.com.convenebackend;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;

import google.com.convenebackend.MainApp.AppMainActivity;

import com.facebook.login.widget.LoginButton;

import org.junit.After;
import org.junit.Before;

/**
 * Created by ekkya on 14/01/2016.
 */
public class AppMainActivityTest extends ActivityInstrumentationTestCase2<AppMainActivity> {

    AppMainActivity activity;
    private LoginButton clickbutton;
    private Button button1;


    public AppMainActivityTest() {
        super(AppMainActivity.class);
    }

    /**
     * Sets up the test fixture for this test case. This method is always called before every test
     * run.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);

        //Get a reference to the Activity under test, starting it if necessary.
        activity = getActivity();

        //Get references to all views
        clickbutton = (LoginButton) activity.findViewById(R.id.login_button);
        button1 = (Button) activity.findViewById(R.id.backBtn);
    }

    @MediumTest
    public void testPreconditions() {
        assertNotNull("AppMainActivity is null", activity);
        assertNotNull("clickbutton is null", clickbutton);
        assertNotNull("back button is null", button1);
    }

    @Before
    public void testClickButton_layout() {
        //Retrieve the top-level window decor view
        final View decorView = activity.getWindow().getDecorView();

        //Verify that the mClickMeButton is on screen
        ViewAsserts.assertOnScreen(decorView, clickbutton);
        ViewAsserts.assertOnScreen(decorView, button1);
    }

    @MediumTest
    public void testClickButton_clickButtonAndExpectInfoText() {
        //Perform a click on clickbutton
        TouchUtils.clickView(this, clickbutton);
        TouchUtils.clickView(this, button1);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
