package axun.com.baisimvpdemo.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import axun.com.baisimvpdemo.Base.BaseActivity;
import axun.com.baisimvpdemo.R;
import axun.com.baisimvpdemo.fragment.JinhuaFragment;
import axun.com.baisimvpdemo.fragment.ShequFragment;
import axun.com.baisimvpdemo.fragment.WodeFragment;
import axun.com.baisimvpdemo.fragment.XintieFragment;
import axun.com.baisimvpdemo.net.URL;
import axun.com.baisimvpdemo.presenter.MainPresenter;
import axun.com.baisimvpdemo.response.ItemTypeBean;
import axun.com.baisimvpdemo.util.SPUtils;
import axun.com.baisimvpdemo.view.MainView;

public class MainActivity extends BaseActivity implements MainView,View.OnClickListener{
    private MainPresenter presenter;
    private FrameLayout mMainContent;
    private TextView mJinhuaBtn;
    private TextView mXintieBtn;
    private ImageView mFabuBtn;
    private TextView mShequBtn;
    private TextView mWodeBtn;
    private ItemTypeBean itemTypeBean;

    //fragment
    private JinhuaFragment jinhuaFragment;
    private XintieFragment xintieFragment;
    private ShequFragment shequFragment;
    private WodeFragment wodeFragment;

    private FragmentManager fgm;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this, getContext());
        //获取tab数据
        presenter.getItemData(true,URL.typeItem);
        fgm = getSupportFragmentManager();

        initView();
    }

    @Override
    public void showTypeItem(ItemTypeBean bean) {
//        itemTypeBean = bean;
    }

    /**
     * 重置所有
     */
    @Override
    public void hideAll() {

        if (jinhuaFragment !=null) transaction.hide(jinhuaFragment);
        if (xintieFragment !=null) transaction.hide(xintieFragment);
        if (shequFragment !=null) transaction.hide(shequFragment);
        if (wodeFragment !=null) transaction.hide(wodeFragment);
        resetAll();
    }

    /**
     * 显示精华fragment
     */
    @Override
    public void showJinhua() {
        mJinhuaBtn.setSelected(true);
        if (jinhuaFragment == null){
            jinhuaFragment = new JinhuaFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("typeItem",itemTypeBean.getMenus().get(0));
            jinhuaFragment.setArguments(bundle);
            transaction.add(R.id.main_content,jinhuaFragment);
        }else {
            transaction.show(jinhuaFragment);
        }
    }

    /**
     * 显示新帖fragment
     */
    @Override
    public void showXintie() {
        mXintieBtn.setSelected(true);
        if (xintieFragment == null){
            xintieFragment = new XintieFragment();
            transaction.add(R.id.main_content,xintieFragment);
        }else {
            transaction.show(xintieFragment);
        }
    }

    /**
     * 显示社区fragment
     */
    @Override
    public void showShequ() {
        mShequBtn.setSelected(true);
        if (shequFragment == null){
            shequFragment = new ShequFragment();
            transaction.add(R.id.main_content,shequFragment);
        }else {
            transaction.show(shequFragment);
        }
    }

    /**
     * 显示我的fragment
     */
    @Override
    public void showWode() {
        mWodeBtn.setSelected(true);
        if (wodeFragment == null){
            wodeFragment = new WodeFragment();
            transaction.add(R.id.main_content,wodeFragment);
        }else {
            transaction.show(wodeFragment);
        }
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

    /**
     * 设置tab
     * @param json
     */
    @Override
    public void showUIData(boolean isRefresh,final String json) {

         Log.d("JSON",json);
         itemTypeBean = JSON.parseObject(json,ItemTypeBean.class);
         if(TextUtils.isEmpty(SPUtils.getStringSp(getContext(),"type_json"))){
             SPUtils.putStringSp(getContext(),"type_json",json);
         }

    }

    @Override
    public void showErrorData(String error) {
        showToast(error);
    }

    @Override
    public void showRefreshNum() {

    }

    @Override
    public void hideRefreshNum() {

    }


    /**
     * 初始化控件
     */
    private void initView() {
        mMainContent = (FrameLayout) findViewById(R.id.main_content);
        mJinhuaBtn = (TextView) findViewById(R.id.jinhua_btn);
        mXintieBtn = (TextView) findViewById(R.id.xintie_btn);
        mFabuBtn = (ImageView) findViewById(R.id.fabu_btn);
        mShequBtn = (TextView) findViewById(R.id.shequ_btn);
        mWodeBtn = (TextView) findViewById(R.id.wode_btn);
        mJinhuaBtn.setOnClickListener(this);
        mXintieBtn.setOnClickListener(this);
        mShequBtn.setOnClickListener(this);
        mFabuBtn.setOnClickListener(this);
        mWodeBtn.setOnClickListener(this);
        mJinhuaBtn.performClick();
    }

    /**
     * 重置选中状态
     */
    private void resetAll(){
        mJinhuaBtn.setSelected(false);
        mXintieBtn.setSelected(false);
        mShequBtn.setSelected(false);
        mWodeBtn.setSelected(false);
    }

    @Override
    public void onClick(View v) {

        transaction = fgm.beginTransaction();
        switch (v.getId()){
            case R.id.jinhua_btn:
                presenter.showJinhua();
                break;
            case R.id.xintie_btn:
               presenter.showXietie();
                break;
            case R.id.shequ_btn:
                presenter.showShequ();
                break;
            case R.id.wode_btn:
                presenter.showWode();
                break;
            case R.id.fabu_btn:
                //TODO:跳转发布

                break;
            default:
                break;
        }
        transaction.commit();
    }


}
