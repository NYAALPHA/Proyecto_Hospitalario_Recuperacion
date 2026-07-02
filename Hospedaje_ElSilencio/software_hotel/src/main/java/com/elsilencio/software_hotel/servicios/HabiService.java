package com.elsilencio.software_hotel.servicios;

import java.math.BigDecimal;
import java.util.List;

import com.elsilencio.software_hotel.modelos.Habitacion;

import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HabiService {
    // CONFIGURAR COLUMNAS DE LA TABLA HABITACIONES
    public static void configurarTablaHabitaciones(TableColumn<Habitacion, Integer> colIdHab,
            TableColumn<Habitacion, String> colNumHab, TableColumn<Habitacion, String> colPisoHab,
            TableColumn<Habitacion, BigDecimal> colPrecioHab, TableColumn<Habitacion, String> colEstadoHab,
            TableColumn<Habitacion, String> colTipoHab, TableColumn<Habitacion, String> colCaracHab) {

        colIdHab.setCellValueFactory(new PropertyValueFactory<>("idhabitacion"));
        colNumHab.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colPisoHab.setCellValueFactory(new PropertyValueFactory<>("piso"));
        colPrecioHab.setCellValueFactory(new PropertyValueFactory<>("precioDiario"));
        colEstadoHab.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colTipoHab.setCellValueFactory(new PropertyValueFactory<>("tipoHabitacion"));
        colCaracHab.setCellValueFactory(new PropertyValueFactory<>("caracteristicas"));
    }

    // INICIALIZAR LISTA DE LAS TABLAS
    public static void listaHabitaciones(TableView<Habitacion> tablaHabitaciones){
        ApiService api = new ApiService();
        try {
            List<Habitacion> allhabitacion = api.listar("habitacion", Habitacion[].class);
            tablaHabitaciones.getItems().setAll(allhabitacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //AGREGAR ELEMENTOS A HABITACION
    public static Habitacion agregarHab(TextField txtNumeroHab, TextField txtPisoHab, TextField txtPrecioHab, SplitMenuButton splitEstadoHab, SplitMenuButton splitTipoHab, TextArea txtCaracteristicaHab,TextArea txtDescripcionHab){
        String numero = txtNumeroHab.getText();
        String piso = txtPisoHab.getText();
        BigDecimal precio = new BigDecimal(txtPrecioHab.getText());
        String estado = splitEstadoHab.getText();
        String tipo = splitTipoHab.getText();
        String carac = txtCaracteristicaHab.getText();
        String desc = txtDescripcionHab.getText();
        Habitacion hab = new Habitacion(numero, piso, desc, carac, precio, estado, tipo);
        return hab;
    }

    //SELECCIONAR HABITACION
    public static void seleccionarHab(TextField txtNumeroHab,TextField txtPisoHab,TextField txtPrecioHab,SplitMenuButton splitEstadoHab, SplitMenuButton splitTipoHab, TextArea txtCaracteristicaHab,TextArea txtDescripcionHab,TableView<Habitacion> tablaHabitaciones
    ){
        Habitacion hab = tablaHabitaciones.getSelectionModel().getSelectedItem();
        txtNumeroHab.setText(hab.getNumero());
        txtPisoHab.setText(hab.getPiso());
        txtPrecioHab.setText(String.valueOf(hab.getPrecioDiario()));
        splitEstadoHab.setText(hab.getEstado());
        splitTipoHab.setText(hab.getTipoHabitacion());
        txtCaracteristicaHab.setText(hab.getCaracteristicas());
        txtDescripcionHab.setText(hab.getDescripcion());
    }
    
    //ELIMINAR ELEMENTOS DE HABITACION
    public static void borrarHab(
        TextField txtNumeroHab,TextField txtPisoHab,TextField txtPrecioHab,
        SplitMenuButton splitEstadoHab, SplitMenuButton splitTipoHab, TextArea txtCaracteristicaHab,
        TextArea txtDescripcionHab){
        txtNumeroHab.setText("");
        txtPisoHab.setText("");
        txtPrecioHab.setText("");
        splitEstadoHab.setText("");
        splitTipoHab.setText("");
        txtCaracteristicaHab.setText("");
        txtDescripcionHab.setText("");
    }
}
