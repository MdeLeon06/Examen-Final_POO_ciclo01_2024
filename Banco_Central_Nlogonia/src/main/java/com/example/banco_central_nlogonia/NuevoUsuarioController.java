package com.example.banco_central_nlogonia;

import com.example.banco_central_nlogonia.Banco.Datos.ClienteDAO;
import com.example.banco_central_nlogonia.Banco.Entidad.Cliente.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NuevoUsuarioController {
    @FXML
    private TextField txtFNombreCompleto;
    @FXML
    private TextField txtFTelefono;
    @FXML
    private TextField txtFDireccion;

    @FXML
    protected void Ingresardatos(){
        String nombreCompleto = txtFNombreCompleto.getText();
        String telefono = txtFTelefono.getText();
        String direccion = txtFDireccion.getText();
        Cliente cliente = new Cliente(nombreCompleto, telefono, direccion);
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insertarDatosCliente(cliente);
    }

}
