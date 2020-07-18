package com.yuugu.cloud.scaffold.page;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;

import com.yuugu.cloud.scaffold.manner.NetworkStateManager;
import com.yuugu.cloud.scaffold.utils.BarUtils;

/**
 * @author: yuugu
 * @date: 2020/7/16
 * 主要是扩展一些常规方法
 */
public abstract class BaseActivity extends BaseVMActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //状态栏沉浸
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);

        //网络监听
        getLifecycle().addObserver(NetworkStateManager.getInstance());
    }

    protected void showLongToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    protected void showShortToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(int stringRes) {
        showLongToast(getApplicationContext().getString(stringRes));
    }

    protected void showShortToast(int stringRes) {
        showShortToast(getApplicationContext().getString(stringRes));
    }
}