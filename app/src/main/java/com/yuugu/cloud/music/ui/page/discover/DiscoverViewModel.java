package com.yuugu.cloud.music.ui.page.discover;

import androidx.lifecycle.ViewModel;
import com.yuugu.cloud.music.domain.request.BannerRequest;

public class DiscoverViewModel extends ViewModel {

    public final BannerRequest bannerRequest = new BannerRequest(this);

}