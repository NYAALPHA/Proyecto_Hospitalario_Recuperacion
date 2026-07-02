package com.elsilencio.software_hotel.servicios;

import java.math.BigDecimal;

import com.elsilencio.software_hotel.modelos.Cliente;
import com.elsilencio.software_hotel.modelos.Habitacion;
import com.elsilencio.software_hotel.modelos.Trabajador;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClieService {
        // CONFIGURAR COLUMNAS DE LA TABLA
    public static void configurarTablaCliente(TableColumn<Cliente, Integer> colId,
            TableColumn<Cliente, String> colNombre, TableColumn<Cliente, String> colDNI,
            TableColumn<Cliente, String> colGenero, TableColumn<Cliente, String> colTelefono, TableColumn<Cliente, String> colEmail) {

        colId.setCellValueFactory(new PropertyValueFactory<>("idpersona"));

        colNombre.setCellValueFactory(cellData -> {
            Cliente c = cellData.getValue();
            String nombreCompleto = c.getNombre() + " " + c.getApaterno() + " " + c.getAmaterno();
            return new SimpleStringProperty(nombreCompleto);
        });

        colDNI.setCellValueFactory(new PropertyValueFactory<>("numDocumento"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    //AGREGAR ELEMENTOS A HABITACION
    public static Cliente agregarCli(TextField txtNombreClie, TextField txtApellidoMClie,TextField txtApellidoPClie, SplitMenuButton splitDNIClie, TextField txtNumeroClie, TextArea txtDireccionClie, TextField txtTelefonoClie, TextField txtEmailClie, SplitMenuButton splitGeneroClie){
        String nombre = txtNombreClie.getText();
        String apellidom = txtApellidoMClie.getText();
        String apellidop = txtApellidoPClie.getText();
        String dni = splitDNIClie.getText();
        String numero = txtNumeroClie.getText();
        String direccion = txtDireccionClie.getText();
        String telefono = txtTelefonoClie.getText();
        String email = txtEmailClie.getText();
        String genero = splitGeneroClie.getText();
        String codigo = String.valueOf((int)(Math.random() * 900) + 100);
        Cliente clie = new Cliente(nombre, apellidop, apellidom, dni, numero, genero, direccion, telefono, email, codigo);
        return clie;
    }

    public static void seleccionarClie( TextField txtNombreClie, TextField txtApellidoMClie,TextField txtApellidoPClie, SplitMenuButton splitDNIClie, TextField txtNumeroClie, TextArea txtDireccionClie, TextField txtTelefonoClie, TextField txtEmailClie, SplitMenuButton splitGeneroClie,TableView<Cliente> tablaCliente
    ){
        Cliente clie = tablaCliente.getSelectionModel().getSelectedItem();
        txtNombreClie.setText(clie.getNombre());
        txtApellidoMClie.setText(clie.getAmaterno());
        txtApellidoPClie.setText(clie.getApaterno());
        splitDNIClie.setText(clie.getTipoDocumento());
        txtNumeroClie.setText(clie.getNumDocumento());
        txtDireccionClie.setText(clie.getDireccion());
        txtTelefonoClie.setText(clie.getTelefono());
        txtEmailClie.setText(clie.getEmail());
        splitGeneroClie.setText(clie.getGenero());
    }

    public static void borrarCli(TextField txtNombreClie, TextField txtApellidoMClie,TextField txtApellidoPClie, SplitMenuButton splitDNIClie, TextField txtNumeroClie, TextArea txtDireccionClie, TextField txtTelefonoClie, TextField txtEmailClie, SplitMenuButton splitGeneroClie){
        txtNombreClie.setText("");
        txtApellidoMClie.setText("");
        txtApellidoPClie.setText("");
        splitDNIClie.setText("");
        txtNumeroClie.setText("");
        txtDireccionClie.setText("");
        txtTelefonoClie.setText("");
        txtEmailClie.setText("");
        splitGeneroClie.setText("");
    }
}