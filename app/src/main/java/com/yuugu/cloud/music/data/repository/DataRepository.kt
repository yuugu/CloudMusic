package com.yuugu.cloud.music.data.repository

import com.yuugu.cloud.music.data.api.ApiService
import com.yuugu.cloud.music.data.bean.BannerEntity
import com.yuugu.network.RetrofitFactory

/**
 * @author: yuugu
 * @date: 2020/7/18
 */

class DataRepository private constructor() {

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = DataRepository()
    }

    suspend fun getBanner():BannerEntity {
        return  RetrofitFactory.instance.getService(ApiService::class.java)
                .getBanner()
    }
}