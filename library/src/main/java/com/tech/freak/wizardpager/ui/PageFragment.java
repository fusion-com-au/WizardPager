package com.tech.freak.wizardpager.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tech.freak.wizardpager.model.Page;


/**
 * Created by jack.leedham on 8/08/2017.
 * The parent class in which all fragments in the wizard pager should inherit from.
 */

public class PageFragment extends Fragment {

    private final String ARG_KEY = "key";
    private String mKey;
    private Page page; // The page the fragment is associated to.
    private PageFragmentCallbacks mCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
    }

    /**
     * Super must be called first.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        page = mCallbacks.onGetPage(mKey);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof PageFragmentCallbacks)) {
            throw new ClassCastException("Activity must implement PageFragmentCallbacks");
        }
        mCallbacks = (PageFragmentCallbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    /**
     * Looks for a given key within the bundle and returns the associated value if it can be found.
     *
     * @param key  The key of the value inside the bundle.
     * @param type The type associated with the value inside bundle
     * @param <T>
     * @return The value if it was found within the bundle of the associated page otherwise return null.
     */
    public <T> T getData(String key, Class<T> type) {
        // get bundle
        if (page.getData().containsKey(key)) {
            Object value = page.getData().get(key);
            if (type.isInstance(value)) {
                return type.cast(value);
            }
        }
        return null;
    }

    /**
     * Get the bundle data from the page associated with this fragment.
     * @return The bundle
     */
    public Bundle getBundle() {
        return page.getData();
    }

    public void notifiyPageDataChanged() {
        page.notifyDataChanged();
    }

}
