package com.yuugu.cloud.music.ui.page.discover;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yuugu.cloud.music.BR;
import com.yuugu.cloud.music.R;
import com.yuugu.cloud.scaffold.page.BaseFragment;
import com.yuugu.cloud.scaffold.page.DataBindingCreator;

public class DiscoverFragment extends BaseFragment {

    private static final String TAG = DiscoverFragment.class.getSimpleName();
    private DiscoverViewModel mDiscoverViewModel;

    @Override
    protected void initViewModel() {
        mDiscoverViewModel = getFragmentViewModel(DiscoverViewModel.class);
    }

    @Override
    protected DataBindingCreator getDataBindingCreator() {
        return new DataBindingCreator(R.layout.discover_fragment, BR.vm, mDiscoverViewModel);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ====LifeActivity");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ====LifeActivity");

        mDiscoverViewModel.bannerRequest.getBannerLiveData().observe(getViewLifecycleOwner(), s -> {
            Log.d(TAG, "数据请求: " +s.getBanners().get(1).getPic());
        });

        mDiscoverViewModel.bannerRequest.requestBanner();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ====LifeActivity");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ====LifeActivity");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ====LifeActivity");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ====LifeActivity");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ====LifeActivity");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ====LifeActivity");
    }
}