package axun.com.baisimvpdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import axun.com.baisimvpdemo.Base.BaseActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this, getContext());
        initView();
        presenter.getItemData(URL.typeItem);
        fgm = getFragmentManager();

    }

    @Override
    public void showTypeItem(ItemTypeBean bean) {
        itemTypeBean = bean;
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
    public void showUIData(String json) {
        itemTypeBean = JSON.parseObject(json,ItemTypeBean.class);
        SPUtils.putBean(getContext(),"item_type",itemTypeBean);
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

    private void hideAll(FragmentTransaction transaction){
        if (jinhuaFragment !=null) transaction.hide(jinhuaFragment);
        if (xintieFragment !=null) transaction.hide(xintieFragment);
        if (shequFragment !=null) transaction.hide(shequFragment);
        if (wodeFragment !=null) transaction.hide(wodeFragment);
    }

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
    }

    private void resetAll(){
        mJinhuaBtn.setSelected(false);
        mXintieBtn.setSelected(false);
        mShequBtn.setSelected(false);
        mWodeBtn.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        resetAll();
        FragmentTransaction transaction = fgm.beginTransaction();
        hideAll(transaction);
        switch (v.getId()){
            case R.id.jinhua_btn:
                mJinhuaBtn.setSelected(true);
                if (jinhuaFragment == null){
                    jinhuaFragment = new JinhuaFragment();
                    transaction.add(R.id.main_content,jinhuaFragment);
                }else {
                    transaction.show(jinhuaFragment);
                }
                break;
            case R.id.xintie_btn:
                mXintieBtn.setSelected(true);
                if (xintieFragment == null){
                    xintieFragment = new XintieFragment();
                    transaction.add(R.id.main_content,xintieFragment);
                }else {
                    transaction.show(xintieFragment);
                }
                break;
            case R.id.shequ_btn:
                mShequBtn.setSelected(true);
                if (shequFragment == null){
                    shequFragment = new ShequFragment();
                    transaction.add(R.id.main_content,shequFragment);
                }else {
                    transaction.show(shequFragment);
                }
                break;
            case R.id.wode_btn:
                mWodeBtn.setSelected(true);
                if (wodeFragment == null){
                    wodeFragment = new WodeFragment();
                    transaction.add(R.id.main_content,wodeFragment);
                }else {
                    transaction.show(wodeFragment);
                }
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
