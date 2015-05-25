package com.qt.bracelet.activity;

import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import org.apache.commons.lang.StringUtils;

import android.widget.EditText;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.StringResComponent;
import com.qt.bracelet.component.ToastComponent;
import com.qt.bracelet.component.ui.LoginComponent;

import java.util.Set;

/**
 * @author rw
 * @ClassName: LoginActivity
 * @Description: 登录
 * @date 2015-1-28 上午11:39:17
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @Bean
    ActivityComponent activityComponent;

    @Bean
    LoginComponent loginComponent;

    @Bean
    ToastComponent toastComponent;

    @Bean
    StringResComponent stringResComponent;

    @ViewById(R.id.login_username_et)
    EditText login_username_et;

    @ViewById(R.id.login_password_et)
    EditText login_password_et;

    @AfterViews
    public void init() {
        login_username_et.setText("leo");
        login_password_et.setText("123");

        JPushInterface.init(getApplicationContext());
        JPushInterface.setAlias(this.getApplication(), "1234567", new TagAliasCallback() {//使用匿名内部类作为回调类
            @Override
            public void gotResult(int arg0, String arg1, Set<String> arg2) {
                Log.d("JPush", "Jpush setAliasAndTags status: " + arg0);//状态
//				if(callback != null){
//					KrollDict map = new KrollDict(); //回调函数的参数
//					map.put("code", arg0);
//					callback.callAsync(getKrollObject(),map); //执行回调
//				}
            }
        });

    }

    /**
     * 登录操作
     */
    @Click(R.id.login_btn)
    public void login() {
        String username = StringUtils.trim(login_username_et.getText().toString());
        String password = StringUtils.trim(login_password_et.getText().toString());
        // 验证用户名，密码
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            toastComponent.show(stringResComponent.login_nameorpas_notempty);
        } else {
            loginComponent.executeLogin(username, password);
        }
        return;
    }

}
