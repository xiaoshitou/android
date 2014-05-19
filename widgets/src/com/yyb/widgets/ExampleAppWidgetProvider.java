package com.yyb.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider {

	final static String MYACTION="com.yyb.widgets.ExampleAppWidgetProvider";
	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("onReceive");
		String action = intent.getAction();
		if(MYACTION.equals(action)){
			//获取远程控件，并操作
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
			remoteViews.setImageViewResource(R.id.myimage, R.drawable.ic_action_call);
			remoteViews.setTextViewText(R.id.mytext, "test");
			
			//获取manager 更新远程的appwidget
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			ComponentName componentName =new ComponentName(context,ExampleAppWidgetProvider.class);
			appWidgetManager.updateAppWidget(componentName, remoteViews);
			
		}else{
			super.onReceive(context, intent);
		}
		
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		System.out.println("onUpdate");
		Intent intent = new Intent();
		intent.setAction(MYACTION);
		//得到一个pendingIntent  包装intent  其实就是预先定义intent
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
		//远程操作控件，其实就是预先 定义 操作 另一个进程中的控件
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
		remoteViews.setOnClickPendingIntent(R.id.mybutton, pendingIntent);
		//更新远程的appwidget
		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
		
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		System.out.println("onDeleted");
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onEnabled(Context context) {
		System.out.println("onEnabled");
		super.onEnabled(context);
	}

	@Override
	public void onDisabled(Context context) {
		System.out.println("onDisabled");
		super.onDisabled(context);
	}

}
