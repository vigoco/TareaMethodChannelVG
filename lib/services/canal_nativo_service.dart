import 'package:flutter/services.dart';

class ChannelNativoServicio {
  static const MethodChannel _canal =
      MethodChannel('com.example.comunicacion_flutter');

  Future<void> mostrarNotificacion(String mensaje) async {
    await _canal.invokeMethod('mostrarNotificacion', {'mensaje': mensaje});
  }

  Future<void> mostrarAlerta(String titulo, String mensaje) async {
    await _canal.invokeMethod('mostrarAlerta', {
      'titulo': titulo,
      'mensaje': mensaje,
    });
  }
}
