package com.yuugu.cloud.music.data.bean

fun <T> BaseResp<T>.dataConvert(): T {
    if (code == 200) {
        return data
    } else {
        throw Exception(msg)
    }
}