package com.austin.android.alexa.actions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.austin.android.alexasdk.AlexaManager;
import com.austin.android.alexasdk.callbacks.AsyncCallback;
import com.austin.android.alexasdk.interfaces.AvsResponse;
import com.austin.android.alexa.R;

import static com.austin.android.alexa.global.Constants.PRODUCT_ID;

/**
 * @author will on 5/30/2016.
 */

public abstract class BaseListenerFragment extends Fragment {

    protected AlexaManager alexaManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get our AlexaManager instance for convenience
        alexaManager = AlexaManager.getInstance(getActivity(), PRODUCT_ID);

        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getActivity() != null) {
            getActivity().setTitle(getTitle());
        }
    }

    protected AsyncCallback<AvsResponse, Exception> getRequestCallback(){
        if(getActivity() != null && getActivity() instanceof AvsListenerInterface){
            return ((AvsListenerInterface) getActivity()).getRequestCallback();
        }
        return null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.about_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                AboutFragment fragment = AboutFragment.getInstance(getTitle(), getAbout());
                loadFragment(fragment);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public abstract void startListening();

    protected abstract String getTitle();

    protected int getAbout() {
        return R.raw.about;
    }

    public interface AvsListenerInterface{
        AsyncCallback<AvsResponse, Exception> getRequestCallback();
    }

    protected void loadFragment(Fragment fragment){
        if(getActivity() != null && getActivity() instanceof ActionsFragment.ActionFragmentInterface){
            ((ActionsFragment.ActionFragmentInterface) getActivity()).loadFragment(fragment, true);
        }
    }
}
