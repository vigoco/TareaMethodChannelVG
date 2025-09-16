import '../services/canal_nativo_service.dart';

class PrincipalViewModel {
  final ChannelNativoServicio _servicio = ChannelNativoServicio();

  void mostrarNotificacion() {
    _servicio.mostrarNotificacion('Holaaa, esto es un toast');
  }

  void mostrarAlerta() {
    _servicio.mostrarAlerta('Alerta Flutter', 'Ejecutado nativamente :)');
  }
}
