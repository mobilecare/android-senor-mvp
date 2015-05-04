package br.com.mobicare.senor.mvp.android.test;

import android.test.InstrumentationTestCase;

import org.mockito.MockitoAnnotations;

public class PresenterTest extends InstrumentationTestCase {

    public void setUp() {
	System.setProperty("dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath());
	MockitoAnnotations.initMocks(this);
    }
}