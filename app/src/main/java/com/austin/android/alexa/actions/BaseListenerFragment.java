package com.austin.android.alexa.actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.austin.android.alexasdk.AlexaManager;
import com.austin.android.alexasdk.callbacks.AsyncCallback;
import com.austin.android.alexasdk.interfaces.AvsResponse;
import com.austin.android.alexa.AboutFragment;
import com.austin.android.alexa.HelpFragment;
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
        inflater.inflate(R.menu.pop_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                share();
                return true;
            case R.id.help:
                HelpFragment helpFragment = new HelpFragment();
                loadFragment(helpFragment);
                return true;
            case R.id.about:
                AboutFragment aboutFragment = new AboutFragment();
                loadFragment(aboutFragment);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void share() {
        String shareTittle = getString(R.string.share_tittle);
        String shareContent = getString(R.string.share_content);
        String shareUrl = getString(R.string.share_url);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareTittle + "\n" + shareContent + "\n" + shareUrl);
        sendIntent.setType("text/plain");
        startActivityForResult(sendIntent, 0);
    }

    public abstract void startListening();

    protected abstract String getTitle();

    public interface AvsListenerInterface{
        AsyncCallback<AvsResponse, Exception> getRequestCallback();
    }

    protected void loadFragment(Fragment fragment){
        if(getActivity() != null && getActivity() instanceof ActionsFragment.ActionFragmentInterface){
            ((ActionsFragment.ActionFragmentInterface) getActivity()).loadFragment(fragment, true);
        }
    }
}
