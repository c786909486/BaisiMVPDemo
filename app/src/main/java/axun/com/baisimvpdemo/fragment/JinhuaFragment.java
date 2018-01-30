package axun.com.baisimvpdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import axun.com.baisimvpdemo.R;
import axun.com.baisimvpdemo.adapter.MyPagerAdapter;
import axun.com.baisimvpdemo.presenter.JinhuaPresenter;
import axun.com.baisimvpdemo.response.ItemTypeBean;
import axun.com.baisimvpdemo.util.StatusBarUtil;
import axun.com.baisimvpdemo.view.JinhuaView;

/**
 * Created by Administrator on 2018/1/26.
 */

public class JinhuaFragment extends Fragment implements JinhuaView,ListFragment.OnListScrollListener{

    private RelativeLayout mTitleBar;
    private ImageView mIconRefresh;
    private ImageView mIconSuiji;
    private TabLayout mTvTab;
    private ViewPager mContentPager;
    private JinhuaPresenter presenter;
    private MyPagerAdapter mAdapter;
    private List<Fragment> contentViews;
    private List<String> titles;
    private boolean isTitleShown = true;
    private int scrollY = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jinghua, container, false);
        presenter = new JinhuaPresenter(this,getContext());
        //设置tab
        contentViews = new ArrayList<>();
        titles = new ArrayList<>();
        initView(view);
        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.baisiColor),0);
        presenter.setTypeItems(this);
        return view;
    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        mTitleBar = view.findViewById(R.id.title_bar);
        mIconRefresh = (ImageView) view.findViewById(R.id.icon_refresh);
        mIconSuiji = (ImageView) view.findViewById(R.id.icon_suiji);
        mTvTab = (TabLayout) view.findViewById(R.id.tv_tab);
        mContentPager = (ViewPager) view.findViewById(R.id.content_pager);
        mContentPager.setOffscreenPageLimit(0);
    }

    /**
     * tabLayout添加数据，绑定tabLayout和viewPager
     * @param bean
     */
    @Override
    public void setTabs(ItemTypeBean.MenusBean bean) {
        //遍历List,获取tab数据
        for (ItemTypeBean.MenusBean.SubmenusBean submenusBean:bean.getSubmenus()){
            mTvTab.addTab(mTvTab.newTab().setText(submenusBean.getName()));
            titles.add(submenusBean.getName());
            ListFragment fragment = new ListFragment();
            //给子fragment传递数据
            Bundle bundle = new Bundle();
            bundle.putString("name",submenusBean.getName());
            bundle.putString("url",submenusBean.getUrl());
            fragment.setArguments(bundle);
            fragment.setListener(this);
            contentViews.add(fragment);
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager(),contentViews,titles);
        mContentPager.setAdapter(mAdapter);
        //绑定viewPager
        mTvTab.setupWithViewPager(mContentPager);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showUIData(boolean isRefresh,String json) {

    }

    @Override
    public void showErrorData(String error) {

    }

    @Override
    public void showRefreshNum() {

    }

    @Override
    public void hideRefreshNum() {

    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Log.d("jinhua","滑动状态："+newState+"\n scrolly:"+scrollY);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        scrollY = dy;
    }
}
