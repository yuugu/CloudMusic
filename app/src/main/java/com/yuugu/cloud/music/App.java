package com.yuugu.cloud.music;

import com.yuugu.cloud.scaffold.BaseApplication;
import com.yuugu.cloud.scaffold.utils.Utils;

/**
 * @Author: yuugu
 * @CreateDate: 2020/6/30 5:04 PM
 */
public class App  extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}