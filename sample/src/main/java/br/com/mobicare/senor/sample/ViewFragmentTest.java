package br.com.mobicare.senor.sample;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class ViewFragmentTest<F extends Fragment> extends ActivityInstrumentationTestCase2<TestFragmentActivity> {
    protected TestFragmentActivity mActivity;
    protected F mFragment;

    public ViewFragmentTest() {
	super(TestFragmentActivity.class);
    }

    private void startActivity() {
	mActivity = getActivity();

	mFragment = startFragment(getFragmentInstance());
    }

    protected abstract F getFragmentInstance();

    @Override
    protected void setUp() throws Exception {
	super.setUp();
	startActivity();
    }

    private F startFragment(F fragment) {
	FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();
	transaction.add(R.id.activity_test_fragment_linearlayout, fragment, "tag");
	transaction.commit();
	getInstrumentation().waitForIdleSync();
	F frag = (F) mActivity.getFragmentManager().findFragmentByTag("tag");
	return frag;
    }

    @Override
    protected void tearDown() throws Exception {
	getActivity().finish();
	super.tearDown();
    }
}