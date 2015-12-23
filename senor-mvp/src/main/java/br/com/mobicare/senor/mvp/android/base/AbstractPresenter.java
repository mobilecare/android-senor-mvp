package br.com.mobicare.senor.mvp.android.base;

public abstract class AbstractPresenter<M extends AbstractModel, V extends AbstractView> {
    
    private M mModel;
    private V mView;

    public AbstractPresenter(M model, V view) {
	this.mModel = model;
	this.mView = view;
    }
    
    public void bind() {
	beforeBinding(mModel, mView);
	bindModelListeners(mModel, mView);
	bindViewListeners(mModel, mView);
	afterBinding(mModel, mView);
    }
    
    protected void beforeBinding(final M model, final V view) {}
    
    protected abstract void bindModelListeners(final M model, final V view);
    
    protected abstract void bindViewListeners(final M model, final V view);
    
    protected void afterBinding(final M model, final V view) {}

}
