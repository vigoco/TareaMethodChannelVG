import 'package:flutter/material.dart';
import '../viewmodels/principal_viewmodel.dart';

class PrincipalVista extends StatelessWidget {
  final PrincipalViewModel _viewModel = PrincipalViewModel();

  PrincipalVista({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pruebas con MethodChannel')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: _viewModel.mostrarNotificacion,
              child: const Text('Mostrar Toast'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _viewModel.mostrarAlerta,
              child: const Text('Mostrar AlertDialog'),
            ),
          ],
        ),
      ),
    );
  }
}
