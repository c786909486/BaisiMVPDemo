package axun.com.baisimvpdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import axun.com.baisimvpdemo.R;

/**
 * Created by Administrator on 2018/1/26.
 */

public class JinhuaFragment extends Fragment {


    private ImageView mIconRefresh;
    private ImageView mIconSuiji;
    private TabLayout mTvTab;
    private ViewPager mContentPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jinghua, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        mIconRefresh = (ImageView) view.findViewById(R.id.icon_refresh);
        mIconSuiji = (ImageView) view.findViewById(R.id.icon_suiji);
        mTvTab = (TabLayout) view.findViewById(R.id.tv_tab);
        mContentPager = (ViewPager) view.findViewById(R.id.content_pager);
    }
}
