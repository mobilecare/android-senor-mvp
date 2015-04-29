package senor.mvp.android;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import br.com.mobicare.mcare_mvp_android.R;

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