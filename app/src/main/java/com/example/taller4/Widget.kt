package com.example.taller4

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.RemoteViews
import android.widget.Toast

class Widget: AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            actualizarWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun actualizarWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.widget)

        val intent = Intent(context, Widget::class.java).apply {
            action = "com.example.taller4.ACTUALIZAR_WIDGET"
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        views.setOnClickPendingIntent(R.id.buttonActualizar, pendingIntent)

        val listaElementos = FragmentListado.listaPublica

        views.removeAllViews(R.id.widgetLista)

        for (item in listaElementos) {
            val itemView = RemoteViews(context.packageName, R.layout.widget_item)
            itemView.setTextViewText(R.id.txtTitulo, item.titulo)
            itemView.setTextViewText(R.id.txtDescripcion, item.descripcion)

            views.addView(R.id.widgetLista, itemView)
        }

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == "com.example.taller4.ACTUALIZAR_WIDGET") {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context, Widget::class.java)
            )

            for (appWidgetId in appWidgetIds) {
                actualizarWidget(context, appWidgetManager, appWidgetId)
            }
        }
    }


}