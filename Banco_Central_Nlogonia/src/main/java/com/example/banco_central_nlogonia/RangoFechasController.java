package com.example.banco_central_nlogonia; // 00126123 Paquete en el que se encuentra la clase

import com.example.banco_central_nlogonia.Banco.Entidad.Transaccion.Transaccion; // 00126123 Importa la clase Transaccion
import com.example.banco_central_nlogonia.Banco.Entidad.Tarjeta.Tarjeta; // 00126123 Importa la clase Tarjeta
import com.example.banco_central_nlogonia.Banco.Conexion.ConexionDB; // 00126123 Importa la clase ConexionDB
import javafx.fxml.FXML; // 00126123 Importa la anotación FXML de JavaFX
import javafx.fxml.Initializable; // 00126123 Importa la interfaz Initializable de JavaFX
import javafx.scene.control.TableColumn; // 00126123 Importa la clase TableColumn de JavaFX
import javafx.scene.control.TableView; // 00126123 Importa la clase TableView de JavaFX
import javafx.scene.control.Alert; // 00126123 Importa la clase Alert de JavaFX
import javafx.scene.control.Button; // 00126123 Importa la clase Button de JavaFX
import javafx.scene.control.DatePicker; // 00126123 Importa la clase DatePicker de JavaFX
import javafx.scene.control.Label; // 00126123 Importa la clase Label de JavaFX
import javafx.scene.control.cell.PropertyValueFactory; // 00126123 Importa PropertyValueFactory para establecer valores de celda

import java.net.URL; // 00126123 Importa la clase URL para manejar URLs
import java.sql.*; // 00126123 Importa clases de SQL para manejar la base de datos
import java.time.LocalDate; // 00126123 Importa la clase LocalDate para manejar fechas
import java.util.ResourceBundle; // 00126123 Importa ResourceBundle para recursos internacionales

public class RangoFechasController implements Initializable { // 00126123 Define la clase controladora que implementa Initializable

    @FXML
    private DatePicker Fecha1_Busqueda_RF; // 00126123 Define el primer DatePicker

    @FXML
    private DatePicker Fecha2_Busqueda_RF; // 00126123 Define el segundo DatePicker

    @FXML
    private Button btn_Buscar_RF; // 00126123 Define el botón de búsqueda

    @FXML
    private TableView<Transaccion> tbl_BusquedaFechas_RF; // 00126123 Define la tabla de transacciones

    @FXML
    private TableColumn<Transaccion, String> ColDescripcion_RF; // 00126123 Define la columna de descripción

    @FXML
    private TableColumn<Transaccion, String> ColFecha_RF; // 00126123 Define la columna de fecha

    @FXML
    private TableColumn<Transaccion, String> ColTarjeta_RF; // 00126123 Define la columna de tarjeta

    @FXML
    private TableColumn<Transaccion, String> ColMonto_RF; // 00126123 Define la columna de monto

    @FXML
    private Label MensajeError_RF; // 00126123 Define la etiqueta para mensajes de error

    private int idCliente; // 00126123 Define una variable para el ID del cliente

    public RangoFechasController() { // 00126123 Constructor
        int idCliente = 1; // 00126123 Inicializa idCliente con un valor predeterminado
        this.idCliente = idCliente; // 00126123 Asigna el valor a la variable de instancia
    }

    @Override // 00126123 Anotación para sobrescribir el método
    public void initialize(URL url, ResourceBundle resourceBundle) { // 00126123 Método de inicialización
        ColDescripcion_RF.setCellValueFactory(new PropertyValueFactory<>("descripcion")); // 00126123 Establece la propiedad de valor de celda para descripción
        ColFecha_RF.setCellValueFactory(new PropertyValueFactory<>("fecha")); // 00126123 Establece la propiedad de valor de celda para fecha
        ColTarjeta_RF.setCellValueFactory(new PropertyValueFactory<>("IdTarjeta")); // 00126123 Establece la propiedad de valor de celda para tarjeta
        ColMonto_RF.setCellValueFactory(new PropertyValueFactory<>("monto")); // 00126123 Establece la propiedad de valor de celda para monto

        btn_Buscar_RF.setOnAction(event -> Busqueda_Compra()); // 00126123 Define la acción del botón de búsqueda
    }

    private void Busqueda_Compra() { // 00126123 Método para realizar la búsqueda de compras
        LocalDate fecha1 = Fecha1_Busqueda_RF.getValue(); // 00126123 Obtiene el valor de la primera fecha
        LocalDate fecha2 = Fecha2_Busqueda_RF.getValue(); // 00126123 Obtiene el valor de la segunda fecha

        if (fecha1 == null || fecha2 == null) { // 00126123 Verifica si las fechas son nulas
            MensajeError("Debe de seleccionar dos fechas para poder continuar."); // 00126123 Muestra un mensaje de error si las fechas son nulas
            return; // 00126123 Finaliza el método si las fechas son nulas
        }

        tbl_BusquedaFechas_RF.getItems().clear(); // 00126123 Limpia los elementos de la tabla

        String query = "SELECT T.Id_Transaccion, T.Fecha_Compra, T.Monto_Total, T.Descripcion, T.Id_Tarjeta " + // 00126123 Define la consulta SQL
                "FROM Transaccion T " + "JOIN Tarjeta TA ON T.Id_Tarjeta = TA.Id_Tarjeta " + // 00126123 Realiza un JOIN entre Transaccion y Tarjeta
                "WHERE TA.Id_Cliente = ? AND T.Fecha_Compra BETWEEN ? AND ?"; // 00126123 Establece las condiciones de la consulta

        try (Connection con = new ConexionDB().conectarDB(); // 00126123 Intenta conectar a la base de datos
             PreparedStatement pstmt = con.prepareStatement(query)) { // 00126123 Prepara la declaración SQL

            pstmt.setInt(1, idCliente); // 00126123 Establece el primer parámetro de la consulta
            pstmt.setDate(2, Date.valueOf(fecha1)); // 00126123 Establece el segundo parámetro de la consulta
            pstmt.setDate(3, Date.valueOf(fecha2)); // 00126123 Establece el tercer parámetro de la consulta

            try (ResultSet rs = pstmt.executeQuery()) { // 00126123 Ejecuta la consulta y obtiene el resultado
                while (rs.next()) { // 00126123 Itera sobre los resultados
                    int idTransaccion = rs.getInt("Id_Transaccion"); // 00126123 Obtiene el ID de la transacción
                    Date fechaCompra = rs.getDate("Fecha_Compra"); // 00126123 Obtiene la fecha de compra
                    float monto = rs.getFloat("Monto_Total"); // 00126123 Obtiene el monto total
                    String descripcion = rs.getString("Descripcion"); // 00126123 Obtiene la descripción
                    int idTarjeta = rs.getInt("Id_Tarjeta"); // 00126123 Obtiene el ID de la tarjeta

                    Transaccion transaccion = new Transaccion(idTransaccion, monto, descripcion, new Tarjeta(), fechaCompra.toLocalDate().toString()); // 00126123 Crea una nueva instancia de Transaccion

                    tbl_BusquedaFechas_RF.getItems().add(transaccion); // 00126123 Añade la transacción a la tabla
                }
            }

        } catch (SQLException e) { // 00126123 Captura las excepciones SQL
            MensajeError("Error al recuperar los datos: " + e.getMessage()); // 00126123 Muestra un mensaje de error
        }
    }

    private void MensajeError(String mensaje) { // 00126123 Método para mostrar mensajes de error
        MensajeError_RF.setText(mensaje); // 00126123 Establece el texto del mensaje de error
        Alert alert = new Alert(Alert.AlertType.ERROR); // 00126123 Crea una alerta de tipo ERROR
        alert.setTitle("Error"); // 00126123 Establece el título de la alerta
        alert.setHeaderText(null); // 00126123 Elimina el encabezado de la alerta
        alert.setContentText(mensaje); // 00126123 Establece el contenido de la alerta
        alert.showAndWait(); // 00126123 Muestra la alerta y espera a que el usuario la cierre
    }
}
