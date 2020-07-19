package com.yuugu.cloud.music.data.repository

import androidx.lifecycle.MutableLiveData
import com.yuugu.cloud.music.data.bean.BannerEntity

/**
 * @author: yuugu
 * @date: 2020/7/19
 */
interface IRemoteSource {
    suspend fun getBanner(liveData: MutableLiveData<BannerEntity>):BannerEntity
}