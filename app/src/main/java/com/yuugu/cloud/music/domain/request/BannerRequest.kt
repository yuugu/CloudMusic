package com.yuugu.cloud.music.domain.request

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuugu.cloud.music.data.api.ApiService
import com.yuugu.cloud.music.data.bean.BannerEntity
import com.yuugu.cloud.music.data.repository.DataRepository
import com.yuugu.network.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author: yuugu
 * @date: 2020/7/19
 */
class BannerRequest(private var model: ViewModel) {

    private lateinit var bannerLiveData: MutableLiveData<BannerEntity>

    fun getBannerLiveData(): LiveData<BannerEntity> {
        bannerLiveData = MutableLiveData()
        return bannerLiveData;
    }

    fun requestBanner() {
        model.viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    DataRepository.instance.getBanner()
                }
                bannerLiveData.value = data
            } catch (e: Exception) {
                Log.d("TAG", "出错了: "+e.message)
            }
        }
    }
}