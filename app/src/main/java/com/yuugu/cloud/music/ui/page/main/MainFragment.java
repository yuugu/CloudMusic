package com.yuugu.cloud.music.ui.page.main;

import com.yuugu.cloud.music.BR;
import com.yuugu.cloud.music.R;
import com.yuugu.cloud.scaffold.page.BaseFragment;
import com.yuugu.cloud.scaffold.page.DataBindingCreator;

public class MainFragment extends BaseFragment {

    private MainViewModel mMainViewModel;

    @Override
    protected void initViewModel() {
        mMainViewModel = getFragmentViewModel(MainViewModel.class);
    }

    @Override
    protected DataBindingCreator getDataBindingCreator() {
        return new DataBindingCreator(R.layout.main_fragment, BR.vm, mMainViewModel);
    }

}