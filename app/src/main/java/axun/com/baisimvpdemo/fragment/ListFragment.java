package axun.com.baisimvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import axun.com.baisimvpdemo.Base.BaseIPresenter;
import axun.com.baisimvpdemo.Base.BaseIView;
import axun.com.baisimvpdemo.R;
import axun.com.baisimvpdemo.adapter.MyContentAdapter;
import axun.com.baisimvpdemo.net.URL;
import axun.com.baisimvpdemo.response.BaisiBean;
import axun.com.baisimvpdemo.ui.BudejieLoadMore;
import axun.com.baisimvpdemo.ui.BudejieRefresh;

/**
 * Created by Administrator on 2018/1/30.
 */

public class ListFragment extends Fragment implements BaseIView{

    private TextView mShowRefreshNum;
    private TwinklingRefreshLayout mRefreshLayout;
    private BudejieRefresh refresh;
    private BudejieLoadMore loadMore;
    private RecyclerView mContentList;
    private MyContentAdapter mAdapter;
    private String name;
    private String url;
    private BaseIPresenter presenter;
    private List<BaisiBean.ListBean> mData;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refresh, container, false);
        getNameAndUrl();
        initView(view);
        presenter = new BaseIPresenter(this,getContext());
        if (!name.equals("直播")){
            presenter.getDataByGet(url+ URL.commonApi(page),true);
        }
        return view;
    }

    private void getNameAndUrl(){
        name = getArguments().getString("name");
        url = getArguments().getString("url");
    }

    private void initView(View view) {
        mShowRefreshNum = (TextView) view.findViewById(R.id.show_refresh_num);
        mRefreshLayout = (TwinklingRefreshLayout) view.findViewById(R.id.refresh_layout);
        mContentList = (RecyclerView) view.findViewById(R.id.content_list);
        refresh = new BudejieRefresh(getContext());
        loadMore = new BudejieLoadMore(getContext());
        mRefreshLayout.setHeaderView(refresh);
        mRefreshLayout.setBottomView(loadMore);
        if (name.equals("视频")){
            mContentList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        }else {
            mContentList.setLayoutManager(new LinearLayoutManager(getContext()));
            mAdapter = new MyContentAdapter(getActivity(),mData);
            mContentList.setAdapter(mAdapter);
        }
        getScroll();
    }

    private void getScroll() {
        mContentList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                listener.onScrollStateChanged(recyclerView,newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                listener.onScrolled(recyclerView, dx, dy);
            }
        });
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
        mRefreshLayout.finishRefreshing();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showUIData(boolean isRefresh,String json) {
        BaisiBean baisiBean = JSON.parseObject(json,BaisiBean.class);
        if (isRefresh){
            mData.removeAll(baisiBean.getList());
            mData.addAll(0,baisiBean.getList());
            if (name.equals("视频")){
                //TODO:视频adapter
            }else {
                mAdapter.notifyDataSetChanged();
            }
        }else {
            mData.removeAll(baisiBean.getList());
            mData.addAll(baisiBean.getList());
            if (name.equals("视频")){

            }else {
                mAdapter.notifyDataSetChanged();
            }
        }


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

    private OnListScrollListener listener;

    public void setListener(OnListScrollListener listener) {
        this.listener = listener;
    }

    public interface OnListScrollListener{
        void onScrollStateChanged(RecyclerView recyclerView, int newState);
        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }
}
