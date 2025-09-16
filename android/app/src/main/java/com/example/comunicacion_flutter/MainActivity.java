package com.example.comunicacion_flutter;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CANAL = "com.example.comunicacion_flutter";

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CANAL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("mostrarNotificacion")) {
                                String mensaje = call.argument("mensaje");
                                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                                result.success(null);
                            } else if (call.method.equals("mostrarAlerta")) {
                                // String titulo = call.argument("titulo");
                                // String mensaje = call.argument("mensaje");
                                // mostrarAlertaNativa(titulo, mensaje);
                                // result.success(null);
                                private void mostrarAlertaNativa(String titulo, String mensaje) {
                                    runOnUiThread(() -> {
                                        new AlertDialog.Builder(this)
                                            .setTitle(titulo)
                                            .setMessage(mensaje)
                                            .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                                            .show();
                                        });
                                }
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }

    private void mostrarNotificacionNativa(String mensaje) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String canalId = "canal_nativo";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(canalId,
                    "Canal Nativo",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, canalId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notificación nativa")
                .setContentText(mensaje)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(1, builder.build());
    }

    private void mostrarAlertaNativa(String titulo, String mensaje) {
        runOnUiThread(() -> {
            new AlertDialog.Builder(this)
                    .setTitle(titulo)
                    .setMessage(mensaje)
                    .setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}
