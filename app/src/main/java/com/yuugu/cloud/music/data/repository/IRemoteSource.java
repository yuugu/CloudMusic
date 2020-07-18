package com.yuugu.cloud.music.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.yuugu.cloud.music.data.bean.BannerEntity;

/**
 * @author: yuugu
 * @date: 2020/7/18
 */
interface IRemoteSource {

    void getBanner(MutableLiveData<BannerEntity> liveData);

}
