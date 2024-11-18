package com.example.taller4

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class Widget: AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            actualizarWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun actualizarWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.widget)

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

}