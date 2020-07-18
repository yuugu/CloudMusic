package com.yuugu.cloud.music.ui.page.main;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

import com.google.android.material.tabs.TabLayout;

public class MainViewModel extends ViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    public final ObservableBoolean initTabAndPage = new ObservableBoolean();

    public final TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    {

        initTabAndPage.set(true);
    }
}