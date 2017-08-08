package com.tech.freak.wizardpager.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.tech.freak.wizardpager.model.Page;


/**
 * Created by jack.leedham on 8/08/2017.
 * The parent class in which all fragments in the wizard pager should inherit from.
 */

public class PageFragment extends Fragment {

    private final String ARG_KEY = "key";
    private Page page; // The page the fragment is associated to.
    private PageFragmentCallbacks mCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        String key = args.getString(ARG_KEY);
        page = mCallbacks.onGetPage(key);
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
