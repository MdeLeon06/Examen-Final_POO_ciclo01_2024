package com.example.banco_central_nlogonia;
import javafx.event.ActionEvent; //00063923 Importa las clases necesarias para manejar eventos de acción en JavaFX.
import javafx.fxml.FXML; //00063923 Importa las clases necesarias para trabajar con FXML.
import javafx.fxml.FXMLLoader; //00063923 Importa las clases necesarias para cargar archivos FXML.
import javafx.scene.Node; //00063923 Importa las clases necesarias para trabajar con nodos en la escena.
import javafx.scene.Parent; //00063923 Importa las clases necesarias para trabajar con el nodo raíz de la escena.
import javafx.scene.Scene; //00063923 Importa las clases necesarias para trabajar con escenas en JavaFX.
import javafx.stage.Stage; //00063923 Importa las clases necesarias para trabajar con ventanas (escenarios) en JavaFX.
import java.io.IOException; //00063923 Importa la clase necesaria para manejar excepciones de entrada/salida.
import Banco.Entidad.Transaccion.Transaccion;
import Banco.Entidad.Tarjeta.Tarjeta;
import Banco.Conexion.ConexionDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RangoFechasController implements Initializable {

    @FXML
    private DatePicker Fecha1_Busqueda_RF;

    @FXML
    private DatePicker Fecha2_Busqueda_RF;

    @FXML
    private Button btn_Buscar_RF;

    @FXML
    private TableView<Transaccion> tbl_BusquedaFechas_RF;

    @FXML
    private TableColumn<Transaccion, String> ColDescripcion_RF;

    @FXML
    private TableColumn<Transaccion, String> ColFecha_RF;

    @FXML
    private TableColumn<Transaccion, String> ColTarjeta_RF;

    @FXML
    private TableColumn<Transaccion, String> ColMonto_RF;

    @FXML
    private Label MensajeError_RF;

    private int idCliente;

    // Constructor
    public RangoFechasController() {
        int idCliente = 1;
        this.idCliente = idCliente;
    }
      @FXML //00063923 Indica que el siguiente método es un controlador de eventos FXML.
    private void volverAInicio(ActionEvent event) throws IOException { //00063923 Método que se ejecuta cuando se desea volver a la pantalla de inicio.
        cargarPantalla(event, "/com/example/banco_central_nlogonia/Inicio-view.fxml"); //00063923 Llama al método cargarPantalla con la ruta del archivo FXML correspondiente a la pantalla de inicio.
    }

    private void cargarPantalla(ActionEvent event, String fxmlPath) throws IOException { //00063923 Método que realiza la carga de la nueva pantalla.
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath)); //00063923 Crea un nuevo FXMLLoader y le da la ruta del archivo FXML a cargar.
        Parent root = loader.load(); //00063923 Carga el archivo FXML y obtiene el nodo raíz.

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //00063923 Obtiene el escenario actual a partir del nodo que disparó el evento.
        stage.setScene(new Scene(root)); //00063923 Establece la nueva escena en el escenario.
        stage.show(); //00063923 Muestra la nueva escena.

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColDescripcion_RF.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        ColFecha_RF.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        ColTarjeta_RF.setCellValueFactory(new PropertyValueFactory<>("IdTarjeta"));
        ColMonto_RF.setCellValueFactory(new PropertyValueFactory<>("monto"));

        btn_Buscar_RF.setOnAction(event -> Busqueda_Compra());
    }

    private void Busqueda_Compra() {
        LocalDate fecha1 = Fecha1_Busqueda_RF.getValue();
        LocalDate fecha2 = Fecha2_Busqueda_RF.getValue();

        if (fecha1 == null || fecha2 == null) {
            MensajeError("Debe de seleccionar dos fechas para poder continuar.");
            return;
        }

        tbl_BusquedaFechas_RF.getItems().clear();

        String query = "SELECT T.Id_Transaccion, T.Fecha_Compra, T.Monto_Total, T.Descripcion, T.Id_Tarjeta " +
                "FROM Transaccion T " + "JOIN Tarjeta TA ON T.Id_Tarjeta = TA.Id_Tarjeta " +
                "WHERE TA.Id_Cliente = ? AND T.Fecha_Compra BETWEEN ? AND ?";

        try (Connection con = new ConexionDB().conectarDB();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, idCliente);
            pstmt.setDate(2, Date.valueOf(fecha1));
            pstmt.setDate(3, Date.valueOf(fecha2));

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idTransaccion = rs.getInt("Id_Transaccion");
                    Date fechaCompra = rs.getDate("Fecha_Compra");
                    float monto = rs.getFloat("Monto_Total");
                    String descripcion = rs.getString("Descripcion");
                    int idTarjeta = rs.getInt("Id_Tarjeta");

                    Transaccion transaccion = new Transaccion(idTransaccion, monto, descripcion, new Tarjeta(), fechaCompra.toLocalDate().toString());

                    tbl_BusquedaFechas_RF.getItems().add(transaccion);
                }
            }

        } catch (SQLException e) {
            MensajeError("Error al recuperar los datos: " + e.getMessage());
        }
    }

    private void MensajeError(String mensaje) {
        MensajeError_RF.setText(mensaje);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();

    }
}
