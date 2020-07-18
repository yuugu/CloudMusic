package com.yuugu.cloud.music.ui.binding;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yuugu.cloud.music.R;
import com.yuugu.cloud.music.ui.adapter.ViewPagerAdapter;
import com.yuugu.cloud.music.ui.page.discover.DiscoverFragment;
import com.yuugu.cloud.music.ui.page.mine.MineFragment;
import com.yuugu.cloud.music.ui.page.video.VideoFragment;
import com.yuugu.cloud.music.ui.page.village.VillageFragment;
import com.yuugu.cloud.scaffold.page.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TabPageBindingAdapter {

    private static final String TAG = TabPageBindingAdapter.class.getSimpleName();

    @BindingAdapter(value = {"initTabAndPage"}, requireAll = false)
    public static void initTabAndPage(TabLayout tabLayout, boolean initTabAndPage) {
        String[] title = new String[4];
        title[0] = "我的";
        title[1] = "发现";
        title[2] = "云村";
        title[3] = "视频";

        List<BaseFragment> list = new ArrayList<>();
        list.add(new MineFragment());
        list.add(new DiscoverFragment());
        list.add(new VillageFragment());
        list.add(new VideoFragment());

        ViewPager viewPager = (tabLayout.getRootView()).findViewById(R.id.view_pager);
        if (viewPager != null) {
            viewPager.setAdapter(new ViewPagerAdapter(((AppCompatActivity) tabLayout.getContext()).getSupportFragmentManager(), list));
            tabLayout.setupWithViewPager(viewPager);
            viewPager.setCurrentItem(1);
            viewPager.setOffscreenPageLimit(title.length);
        }

        for (int i = 0; i < title.length; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                //设置自定义view
                tab.setCustomView(R.layout.main_fragment_tab_item);
                ((TextView) Objects.requireNonNull(tab.getCustomView()).findViewById(R.id.tv_item)).setText(title[i]);
                if (tab.getPosition() == 1) {
                    changeTabSelect(tab);
                } else {
                    changeTabNormal(tab);
                }
            }
        }

        /**
         * 设置TabLayout的选中监听
         */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTabSelect(tab);   //Tab获取焦点
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                changeTabNormal(tab);   //Tab失去焦点
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    /**
     * 改变TabLayout的View到选中状态
     * 使用属性动画改编Tab中View的状态
     */
    private static void changeTabSelect(TabLayout.Tab tab) {
        final View view = tab.getCustomView();
        assert view != null;
        TextView textView = ((TextView) view.findViewById(R.id.tv_item));
        TextPaint paint = textView.getPaint();
        paint.setFakeBoldText(true);
        textView.setTextColor(Color.parseColor("#000000"));
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator anim = ObjectAnimator
                .ofFloat(textView, "", 1.0F, 1.1F)
                .setDuration(100);
        anim.start();
        anim.addUpdateListener(animation -> {
            float cVal = (Float) animation.getAnimatedValue();
            textView.setAlpha(0.5f + (cVal - 1f) * (0.5f / 0.1f));
            textView.setScaleX(cVal);
            textView.setScaleY(cVal);
        });
    }

    /**
     * 改变TabLayout的View到未选中状态
     */
    private static void changeTabNormal(TabLayout.Tab tab) {
        final View view = tab.getCustomView();
        assert view != null;
        TextView textView = ((TextView) view.findViewById(R.id.tv_item));
        TextPaint paint = textView.getPaint();
        paint.setFakeBoldText(false);
        textView.setTextColor(Color.parseColor("#323031"));
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator anim = ObjectAnimator
                .ofFloat(textView, "", 1.0F, 0.9F)
                .setDuration(100);
        anim.start();
        anim.addUpdateListener(animation -> {
            float cVal = (Float) animation.getAnimatedValue();
            textView.setAlpha(1f - (1f - cVal) * (0.5f / 0.1f));
            textView.setScaleX(cVal);
            textView.setScaleY(cVal);
        });
    }
}
