package com.youngmanster.collection.customview.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.youngmanster.collection.R;
import com.youngmanster.collection.base.BaseActivity;
import com.youngmanster.collection.customview.fragment.ChildFragment;
import com.youngmanster.collectionlibrary.customview.tablayout.CommonTabLayout;
import com.youngmanster.collectionlibrary.customview.tablayout.OutSideFrameTabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yangyan on 2018/7/9.
 */

public class OutSideFrameTabLayoutOneActivity  extends BaseActivity {

    @BindView(R.id.customTabView)
    OutSideFrameTabLayout customTabView;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private String[] strArray = new String[]{"精选", "爱看"};

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> strList = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.activity_custom_outsideframetablayout_one;
    }

    @Override
    public void init() {
        setTitleContent(getString(R.string.tab_Indicator_title));
        showHomeAsUp(R.mipmap.ic_back_btn);

        initData();

       CustomTabPagerAdapter indexPagerAdapter = new CustomTabPagerAdapter(getSupportFragmentManager(),strList,fragmentList);
        viewPager.setAdapter(indexPagerAdapter);
        customTabView.setupWithViewPager(viewPager);

    }

    @Override
    public void requestData() {

    }

    private void initData() {
        strList.addAll(Arrays.asList(strArray));
        for (int i=0;i<strList.size();i++) {
            Fragment fragment = ChildFragment.newInstance(strList.get(i));
            fragmentList.add(fragment);
        }
    }


    class CustomTabPagerAdapter extends FragmentPagerAdapter {
        private List<String> titleList;

        public CustomTabPagerAdapter(FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
            super(fm);
            this.titleList = titleList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return titleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
