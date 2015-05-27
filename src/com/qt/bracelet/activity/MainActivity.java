package com.qt.bracelet.activity;

import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import com.googlecode.androidannotations.annotations.*;
import com.qt.bracelet.R;
import com.qt.bracelet.common.BraceletApp;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.ui.MainComponent;
import com.qt.bracelet.domain.Bracelet;
import com.qt.bracelet.domain.User;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Set;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Bean
    MainComponent mainComponent;

    @Bean
    ActivityComponent activityComponent;

    @App
    BraceletApp braceletApp;

    @AfterViews
    public void init() {
        JPushInterface.init(getApplicationContext());
        User user = User.checkLogin(braceletApp.getUsername());
        if (user != null) {
            List<Bracelet> bracelets = user.bracelets;
            if (CollectionUtils.isNotEmpty(bracelets)) {
                for (Bracelet bracelet : bracelets) {
                    JPushInterface.setAlias(this.getApplication(), bracelet.braceletId, new TagAliasCallback() {//使用匿名内部类作为回调类
                        @Override
                        public void gotResult(int arg0, String arg1, Set<String> arg2) {
                            Log.d("JPush", "Jpush setAliasAndTags status: " + arg0);//状态
                        }
                    });
                }
            }
        }
        mainComponent.requestData();
    }

    @Click(R.id.setting_iv)
    public void toSetting() {
        activityComponent.startSetting();
    }

    @Click(R.id.btu_logout)
    public void logout() {
        activityComponent.startLogin();
    }
}
