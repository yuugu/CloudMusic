package com.yuugu.cloud.music.data.repository

import androidx.lifecycle.MutableLiveData
import com.yuugu.cloud.music.data.api.ApiService
import com.yuugu.cloud.music.data.bean.BannerEntity
import com.yuugu.network.RetrofitFactory

/**
 * @author: yuugu
 * @date: 2020/7/18
 */

class DataRepository private constructor() : ILocalSource, IRemoteSource {

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = DataRepository()
    }

    override suspend fun getBanner(liveData: MutableLiveData<BannerEntity>):BannerEntity {
       return RetrofitFactory.instance.getService(ApiService::class.java)
                .getBanner()
    }
}