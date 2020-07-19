package com.yuugu.cloud.music.data.api

import com.yuugu.cloud.music.data.bean.BannerEntity
import retrofit2.http.GET

/**
 * @author: yuugu
 * @date: 2020/7/18
 */
interface ApiService {

    //获取轮播图
    @GET("/banner?type=1")
    suspend fun getBanner(): BannerEntity
}