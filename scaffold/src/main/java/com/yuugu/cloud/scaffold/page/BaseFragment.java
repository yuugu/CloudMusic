package com.yuugu.cloud.scaffold.page;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yuugu.cloud.scaffold.manner.NetState;
import com.yuugu.cloud.scaffold.manner.NetworkStateManager;

/**
 * @author: yuugu
 * @date: 2020/7/16
 */
public abstract class BaseFragment extends BaseVMFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //订阅网络相关
        NetworkStateManager.getInstance().networkStateCallback.observe(getViewLifecycleOwner(), this::onNetworkStateChanged);
    }

    @SuppressWarnings("EmptyMethod")
    protected void onNetworkStateChanged(NetState netState) {
        //TODO 子类可以重写该方法，统一的网络状态通知和处理
    }
}