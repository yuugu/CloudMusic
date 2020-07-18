package com.yuugu.cloud.music.ui.page.village;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yuugu.cloud.music.BR;
import com.yuugu.cloud.music.R;
import com.yuugu.cloud.scaffold.page.BaseFragment;
import com.yuugu.cloud.scaffold.page.DataBindingCreator;

public class VillageFragment extends BaseFragment {

    private static final String TAG = VillageFragment.class.getSimpleName();
    private VillageViewModel mVillageViewModel;

    @Override
    protected void initViewModel() {
        mVillageViewModel = getFragmentViewModel(VillageViewModel.class);
    }

    @Override
    protected DataBindingCreator getDataBindingCreator() {
        return new DataBindingCreator(R.layout.village_fragment, BR.vm, mVillageViewModel);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ====LifeActivity");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ====LifeActivity");
        return super.onCreateView(inflater, container, savedInstanceState);
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
}