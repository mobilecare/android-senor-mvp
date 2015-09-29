package br.com.mobicare.senor.sample;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;



public class TestFragmentActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle bundle) {
	super.onCreate(bundle);
	
	setContentView(R.layout.activity_fortests);
    }
    
    public static boolean isEmulator() {
	return Build.PRODUCT.startsWith("vbox");
    }
    
}