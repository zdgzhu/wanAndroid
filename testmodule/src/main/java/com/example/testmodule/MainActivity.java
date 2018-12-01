package com.example.testmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.testmodule.dagger2.DaggerFactoryActivityComponent;
import com.example.testmodule.dagger2.Product;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public  String TAG = "TAG_" + getClass().getSimpleName();
    @BindView(R.id.btn_testMain_01)
    Button btn01;

    @Inject
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerFactoryActivityComponent.builder().build().inject1(this);


    }


    @OnClick(R.id.btn_testMain_01)
    public void btnDagger2() {
        Log.e(TAG, "---------start----btnDagger2: --------------" );
        Toast.makeText(this, "被点击了" , Toast.LENGTH_SHORT).show();
//       /test1/FactoryActivity

        Log.d(TAG, "btnDagger2: MainActivity .product = " +product.getData());




        ARouter.getInstance()
                .build("/actTest/FactoryActivity")
                .navigation();
//        Log.e(TAG, "---------end----btnDagger2:------------- " );

    }


}
