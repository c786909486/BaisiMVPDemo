package axun.com.baisimvpdemo.Base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/26.
 */

public class BaseActivity extends AppCompatActivity {

    protected Context getContext(){
        return this.getApplicationContext();
    }

    public void showToast(String toast){
        Toast.makeText(getContext(),toast,Toast.LENGTH_SHORT).show();
    }
}
