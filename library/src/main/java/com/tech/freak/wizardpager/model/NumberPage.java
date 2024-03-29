package com.tech.freak.wizardpager.model;

import androidx.fragment.app.Fragment;

import com.tech.freak.wizardpager.ui.NumberFragment;

public class NumberPage extends TextPage {

	public NumberPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return NumberFragment.create(getKey());
	}

}
