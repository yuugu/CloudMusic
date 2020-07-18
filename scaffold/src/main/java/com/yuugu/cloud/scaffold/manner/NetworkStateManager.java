package com.yuugu.cloud.scaffold.manner;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.yuugu.cloud.scaffold.livedata.UnPeekLiveData;
import com.yuugu.cloud.scaffold.utils.Utils;


/**
 * @author: yuugu
 * @date: 2020/7/16
 */
public class NetworkStateManager implements DefaultLifecycleObserver {
    private static final NetworkStateManager S_MANAGER = new NetworkStateManager();
    public final UnPeekLiveData<NetState> networkStateCallback = new UnPeekLiveData<>();
    private NetworkStateReceive mNetworkStateReceive;

    private NetworkStateManager() {
    }

    public static NetworkStateManager getInstance() {
        return S_MANAGER;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        mNetworkStateReceive = new NetworkStateReceive();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        Utils.getApp().getApplicationContext().registerReceiver(mNetworkStateReceive, filter);
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Utils.getApp().getApplicationContext().unregisterReceiver(mNetworkStateReceive);
    }
}