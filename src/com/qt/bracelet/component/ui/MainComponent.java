package com.qt.bracelet.component.ui;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import com.googlecode.androidannotations.annotations.*;
import com.qt.bracelet.R;
import com.qt.bracelet.common.BraceletApp;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.component.ToastComponent;
import com.qt.bracelet.domain.User;
import com.qt.bracelet.mapping.HealDataMapping;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author rw
 * @ClassName: MainComponent
 * @Description: 主页组件
 * @date 2015-2-2 下午2:46:06
 */
@EBean
public class MainComponent {

    @RootContext
    Context context;

    @RootContext
    Activity activity;

    @Bean
    ToastComponent toastComponent;

    @ViewById(R.id.temp_value)
    EditText tempValue;

    @ViewById(R.id.pulse_value)
    EditText pulseValue;

    @ViewById(R.id.sbp_value)
    EditText sbpValue;

    @ViewById(R.id.dbp_value)
    EditText dbpValue;

    @ViewById(R.id.motion_value)
    EditText motionValue;

    @App
    BraceletApp braceletApp;

    @Click(R.id.btu_request)
    public void requestData() {
        User user = User.checkLogin(braceletApp.getUsername());
        if (user == null) {
            toastComponent.show("用户不存在");
        } else {
            obtainVitalSigns(user);
        }
    }

    @Background
    public void obtainVitalSigns(User user) {
        HealDataMapping.HealData bean = null;
        if(CollectionUtils.isNotEmpty(user.bracelets)){
            String url = Constants.URL_FINDBYLATEST_PATH + user.bracelets.get(0).braceletId;
            HealDataMapping data = HealDataMapping.getJSON(url);
            if (data.code == Constants.STATUS_SUCCESS) {
                bean = data.datas;
            }
        }
        updateUI(bean);
    }

    @UiThread
    void updateUI(HealDataMapping.HealData bean) {
        if (bean != null) {
            tempValue.setText(bean.temperature);
            pulseValue.setText(bean.pulseState);
            sbpValue.setText(bean.sbp);
            dbpValue.setText(bean.dbp);
            motionValue.setText(bean.motionState);
        } else {
            toastComponent.show("该用户没有手环。");
        }

    }

}
