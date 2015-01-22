package com.qt.bracelet.component;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.googlecode.androidannotations.api.Scope;
import com.qt.bracelet.component.SharedPreferencesComponent_;

/**
 * 更新组件
 * 
 * @author superleo
 * 
 */
// 定义成一个可以注入的组件
@EBean(scope = Scope.Singleton)
public class LanguageComponent {

	// 注入 Context 变量
	@RootContext
	Context context;

	@Pref
	SharedPreferencesComponent_ myPrefs;

	@Bean
	ActivityComponent activityComponent;

	@Bean
	ToastComponent toastComponent;

	@Bean
	StringResComponent stringResComponent;

	/**
	 * 读取当前系统语言
	 */
	public void readLanguage() {
		String type = myPrefs.language().get();
		if (StringUtils.equalsIgnoreCase(type, Locale.SIMPLIFIED_CHINESE.getLanguage())) {
			readLanguage(Locale.SIMPLIFIED_CHINESE);
		} else {
			readLanguage(Locale.ENGLISH);
		}
	}

	/**
	 * 读取当前系统语言
	 * 
	 * @param locale
	 *            本地语言参数
	 */
	private void readLanguage(Locale locale) {
		Resources res = context.getResources();
		Configuration config = res.getConfiguration();
		config.locale = locale;
		DisplayMetrics dm = res.getDisplayMetrics();
		res.updateConfiguration(config, dm);

	}

	/**
	 * 更新系统语言
	 * 
	 * @param locale 要更新的语言参数
	 */
	public void updateLanguage(Locale locale) {
		Resources res = context.getResources();
		Configuration config = res.getConfiguration();
		config.locale = locale;
		DisplayMetrics dm = res.getDisplayMetrics();
		res.updateConfiguration(config, dm);
		myPrefs.language().put(locale.getLanguage());
//		toastComponent.showLong(stringResComponent.toastSettingSucc);
	}

}
