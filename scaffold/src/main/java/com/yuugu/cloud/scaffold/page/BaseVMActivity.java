package com.yuugu.cloud.scaffold.page;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yuugu.cloud.scaffold.BaseApplication;

/**
 * @author: yuugu
 * @date: 2020/7/15
 * 隔离一下关于ViewModel+DataBinding的处理
 */
public abstract class BaseVMActivity extends AppCompatActivity {

    private ViewModelProvider mActivityProvider;
    private ViewModelProvider.Factory mFactory;
    private ViewDataBinding mBinding;

    protected abstract void initViewModel();

    protected abstract DataBindingCreator getDataBindingCreator();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化ViewModel
        initViewModel();

        //获取子类中的DataBindingParams -- 不向子类暴露是为了提升视图调用的安全性
        DataBindingCreator dataBindingConfig = getDataBindingCreator();
        ViewDataBinding binding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayout());
        binding.setLifecycleOwner(this);
        binding.setVariable(dataBindingConfig.getVmVariableId(), dataBindingConfig.getStateViewModel());
        SparseArray<Object> bindingParams = dataBindingConfig.getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
        mBinding = binding;
    }

    //------处理ViewModel相关--------开始-
    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    protected ViewModelProvider getAppViewModelProvider() {
        return new ViewModelProvider((BaseApplication) this.getApplicationContext(),
                getAppFactory(this));
    }

    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application application = checkApplication(activity);
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return mFactory;
    }

    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }
    //------处理ViewModel相关--------结束-
}