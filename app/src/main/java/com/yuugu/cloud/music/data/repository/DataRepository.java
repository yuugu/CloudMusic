package com.yuugu.cloud.music.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.yuugu.cloud.music.data.bean.BannerEntity;

/**
 * @author: yuugu
 * @date: 2020/7/18
 */
public class DataRepository implements ILocalSource, IRemoteSource {

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    private DataRepository() {
    }

    @Override
    public void getBanner(MutableLiveData<BannerEntity> liveData) {
        //处理banner数据请求
    }
}