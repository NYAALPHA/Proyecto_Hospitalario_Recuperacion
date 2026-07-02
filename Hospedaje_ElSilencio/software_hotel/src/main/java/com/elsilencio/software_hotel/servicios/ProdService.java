package com.elsilencio.software_hotel.servicios;

import java.math.BigDecimal;

import com.elsilencio.software_hotel.modelos.Producto;

import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdService {
    // CONFIGURAR COLUMNAS DE LA TABLA PRODUCTOS
    public static void configurarTablaProductos(
            TableColumn<Producto, Integer> colIdProd,
            TableColumn<Producto, String> colNombreProd,
            TableColumn<Producto, BigDecimal> colPrecioProd,
            TableColumn<Producto, String> colUniProd,
            TableColumn<Producto, String> colDescProd) {
        colIdProd.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        colNombreProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecioProd.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        colUniProd.setCellValueFactory(new PropertyValueFactory<>("unidadMedida"));
        colDescProd.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    public static Producto agregarProd(TextField txtNombreProd, TextField txtPrecioProd, SplitMenuButton splitUnidadProd, TextArea txtDescripcionProd){
        String nombre = txtNombreProd.getText();
        BigDecimal precio = new BigDecimal(txtPrecioProd.getText());
        String unidad = splitUnidadProd.getText();
        String descripcion = txtDescripcionProd.getText();
        Producto prod = new Producto(nombre, precio, unidad, descripcion);
        return prod;
    }

    public static void seleccionarProd(TextField txtNombreProd, TextField txtPrecioProd, SplitMenuButton splitUnidadProd, TextArea txtDescripcionProd,TableView<Producto> tablaProducto){
        Producto prod = tablaProducto.getSelectionModel().getSelectedItem();
        txtNombreProd.setText(prod.getNombre());
        txtPrecioProd.setText(String.valueOf(prod.getPrecioVenta()));
        splitUnidadProd.setText(prod.getUnidadMedida());
        txtDescripcionProd.setText(prod.getDescripcion());
    }

    public static void borrarProd(TextField txtNombreProd, TextField txtPrecioProd, SplitMenuButton splitUnidadProd, TextArea txtDescripcionProd){
        txtNombreProd.setText("");
        txtPrecioProd.setText("");
        splitUnidadProd.setText("");
        txtDescripcionProd.setText("");
    }
}
