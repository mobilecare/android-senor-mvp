package senor.mvp.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import br.com.mobicare.senor.AbstractEventer;


public abstract class AbstractView extends AbstractEventer {

    private View mView;
    protected Context mContext;

    public AbstractView(Context context) {
	mContext = context;
	mView = LayoutInflater.from(context).inflate(getLayoutResource(), null);

	loadViews(mView);
	setViewListeners();
    }
    
    protected abstract int getLayoutResource();
    
    protected abstract void loadViews(View parentView);

    protected abstract void setViewListeners();
    
    public final View getView() {
	return mView;
    }
}
