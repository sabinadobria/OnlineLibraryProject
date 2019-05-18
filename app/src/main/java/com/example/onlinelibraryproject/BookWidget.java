package com.example.onlinelibraryproject;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class BookWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
      for(int appWidgetId: appWidgetIds){
          Intent intent = new Intent(context, MainActivity.class);
          PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

          RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.book_widget);
          views.setOnClickPendingIntent(R.id.id_widget_button, pendingIntent);

          appWidgetManager.updateAppWidget(appWidgetId, views);
      }
    }

}

