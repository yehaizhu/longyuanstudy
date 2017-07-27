package com.longyuan.study.longyuanstudy.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.longyuan.study.longyuanstudy.ui.fragment.InteractiveFragment;
import com.longyuan.study.longyuanstudy.ui.fragment.MyFragment;
import com.longyuan.study.longyuanstudy.ui.fragment.ResourcesFragment;
import com.longyuan.study.longyuanstudy.ui.fragment.StudyFragment;
import com.zhuyehai.base.common.CommonTabFragmentAdapter;
import com.zhuyehai.base.ui.BaseActiviy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by zhuyehai on 17/6/16.
 */

public class MainActivity extends BaseActiviy implements ViewPager.OnPageChangeListener {
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    private List<String> mTabList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private List<View> views = new ArrayList<>();
    private int[] mTabImgs = new int[]{R.mipmap.jingxuan, R.mipmap.jingxuan, R.mipmap.jingxuan, R.mipmap.jingxuan};
    private int[] mSelTabImgs = new int[]{R.mipmap.jingxuan_blue, R.mipmap.jingxuan_blue, R.mipmap.jingxuan_blue, R.mipmap.jingxuan_blue};


    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void getData() {
        initFragment();
        initTabList();
        FragmentManager fm = getSupportFragmentManager();
        CommonTabFragmentAdapter homePagerAdapter = new CommonTabFragmentAdapter(fm);
        homePagerAdapter.addTab(mFragments.get(0), mTabList.get(0));
        homePagerAdapter.addTab(mFragments.get(1), mTabList.get(1));
        homePagerAdapter.addTab(mFragments.get(2), mTabList.get(2));
        homePagerAdapter.addTab(mFragments.get(3), mTabList.get(3));

        mViewPager.addOnPageChangeListener(this);
        mViewPager.setAdapter(homePagerAdapter);
        mTablayout.setupWithViewPager(mViewPager);


        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
            ImageView mTabIcon = (ImageView) view.findViewById(R.id.main_tab_img);
            mTabIcon.setImageDrawable(this.getResources().getDrawable(mTabImgs[i]));
            TextView mTabText = (TextView) view.findViewById(R.id.main_tab_tv);
            mTabText.setText(mTabList.get(i));
            views.add(view);
            if (0 == i) {
//                mTabText.setTextColor(ContextCompat.getColor(this, R.color.red_text));
                mTabIcon.setImageResource(mSelTabImgs[0]);
            }
            mTablayout.getTabAt(i).setCustomView(view);

        }


    }


    private void initTabList() {
        mTabList.clear();
        mTabList.add("资源");
        mTabList.add("互动");
        mTabList.add("学习");
        mTabList.add("我的");
    }

    public void initFragment() {
        mFragments.add(new ResourcesFragment());
        mFragments.add(new InteractiveFragment());
        mFragments.add(new StudyFragment());
        mFragments.add(new MyFragment());
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            initView(i,mTabImgs,R.color.black);
        }
        if (!views.isEmpty()) {
            initView(position,mSelTabImgs,R.color.red_text);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initView(int postion,int[] img,int color) {
        View view = views.get(postion);
        ImageView mTabIcon = (ImageView) view.findViewById(R.id.main_tab_img);
        mTabIcon.setImageResource(img[postion]);
        TextView mTabText = (TextView) view.findViewById(R.id.main_tab_tv);
        mTabText.setTextColor(ContextCompat.getColor(this, color));

    }





}
