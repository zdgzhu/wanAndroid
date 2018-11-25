package com.example.testmodule.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.testmodule.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/actTest/FactoryActivity")
public class FactoryActivity extends AppCompatActivity {

    @Inject
    Product product;
    @BindView(R.id.btn_dagger_01)
    Button btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);

        ButterKnife.bind(this);



    }


    @OnClick(R.id.btn_dagger_01)
    public void onClick() {
        DaggerFactoryActivityComponent.builder()
           .mainModule(new MainModule("tag"))
                .build().inject(this);
        String str = this.product.createProduct();
        Toast.makeText(this, "act "+str, Toast.LENGTH_SHORT).show();
    }



}
