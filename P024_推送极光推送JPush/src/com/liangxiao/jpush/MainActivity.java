package com.liangxiao.jpush;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		// 设置别名
		JPushInterface.setAlias(this, "刘金兰", new TagAliasCallback() {

			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2) {
				Log.d("TAG", "设置别名：" + arg0);
			}
		});

		// 设置Tag
		Set<String> sets = new HashSet<String>();
		sets.add("lan1");// lan3 设置不同的标签分类发送消息
		sets.add("lan2");
		JPushInterface.setTags(this, sets, new TagAliasCallback() {

			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2) {
				Log.d("TAG", "设置标签：" + arg0);
			}
		});
	}
}
