package com.yuugu.cloud.music.ui.page.main;

import com.yuugu.cloud.music.AppViewModel;
import com.yuugu.cloud.music.BR;
import com.yuugu.cloud.music.R;
import com.yuugu.cloud.scaffold.page.BaseActivity;
import com.yuugu.cloud.scaffold.page.DataBindingCreator;

public class MainActivity extends BaseActivity {

    private MainActivityViewModel mMainActivityViewModel;
    private AppViewModel mAppViewModel;

    @Override
    protected void initViewModel() {

    }

    @Override
    protected DataBindingCreator getDataBindingCreator() {
        return new DataBindingCreator(R.layout.activity_main, BR.vm, mMainActivityViewModel);
    }
}