package com.yuugu.cloud.music.domain.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yuugu.cloud.music.data.bean.BannerEntity;
import com.yuugu.cloud.music.data.repository.DataRepository;

/**
 * @author: yuugu
 * @date: 2020/7/18
 */
public class BannerRequest {

    private MutableLiveData<BannerEntity> bannerLiveData;

    public LiveData<BannerEntity> getBannerLiveData() {
        if (bannerLiveData == null) {
            bannerLiveData = new MutableLiveData<>();
        }
        return bannerLiveData;
    }

    public void requestBanner() {
        DataRepository.getInstance().getBanner(bannerLiveData);
    }

}