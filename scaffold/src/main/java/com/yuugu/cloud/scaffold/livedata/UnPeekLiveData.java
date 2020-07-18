package com.yuugu.cloud.scaffold.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: yuugu
 * @date: 2020/7/16
 * UnPeekLiveData 的存在是为了在 "重回二级页面" 的场景下，解决 "数据倒灌" 的问题。
 */
public class UnPeekLiveData<T> extends MutableLiveData<T> {

    private boolean isCleaning;
    private boolean hasHandled = true;
    private boolean isDelaying;
    private int DELAY_TO_CLEAR_EVENT = 1000;
    private Timer mTimer = new Timer();
    private TimerTask mTask;
    private boolean isAllowNullValue;

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {

        super.observe(owner, t -> {

            if (isCleaning) {
                hasHandled = true;
                isDelaying = false;
                isCleaning = false;
                return;
            }

            if (!hasHandled) {
                hasHandled = true;
                isDelaying = true;
                observer.onChanged(t);
            } else if (isDelaying) {
                observer.onChanged(t);
            }
        });
    }

    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {

        super.observeForever(t -> {

            if (isCleaning) {
                hasHandled = true;
                isDelaying = false;
                isCleaning = false;
                return;
            }

            if (!hasHandled) {
                hasHandled = true;
                isDelaying = true;
                observer.onChanged(t);
            } else if (isDelaying) {
                observer.onChanged(t);
            }
        });
    }

    /**
     * 重写的 setValue 方法，默认不接收 null
     * 可通过 Builder 配置允许接收
     * 可通过 Builder 配置消息延时清理的时间
     * override setValue, do not receive null by default
     * You can configure to allow receiving through Builder
     * And also, You can configure the delay time of message clearing through Builder
     *
     * @param value
     */
    @Override
    public void setValue(T value) {

        if (!isAllowNullValue && value == null && !isCleaning) {
            return;
        }

        hasHandled = false;
        isDelaying = false;
        super.setValue(value);

        if (mTask != null) {
            mTask.cancel();
            mTimer.purge();
        }

        mTask = new TimerTask() {
            @Override
            public void run() {
                clear();
            }
        };
        mTimer.schedule(mTask, DELAY_TO_CLEAR_EVENT);
    }

    private void clear() {
        isCleaning = true;
        super.postValue(null);
    }

    public static class Builder<T> {

        /**
         * 消息的生存时长
         */
        private int eventSurvivalTime = 1000;

        /**
         * 是否允许传入 null value
         */
        private boolean isAllowNullValue;

        public Builder<T> setEventSurvivalTime(int eventSurvivalTime) {
            this.eventSurvivalTime = eventSurvivalTime;
            return this;
        }

        public Builder<T> setAllowNullValue(boolean allowNullValue) {
            this.isAllowNullValue = allowNullValue;
            return this;
        }

        public UnPeekLiveData<T> create() {
            UnPeekLiveData<T> liveData = new UnPeekLiveData<>();
            liveData.DELAY_TO_CLEAR_EVENT = this.eventSurvivalTime;
            liveData.isAllowNullValue = this.isAllowNullValue;
            return liveData;
        }
    }
}
