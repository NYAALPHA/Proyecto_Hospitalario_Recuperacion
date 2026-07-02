package com.elsilencio.software_hotel.controlador;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.elsilencio.software_hotel.modelos.Cliente;
import com.elsilencio.software_hotel.modelos.Habitacion;
import com.elsilencio.software_hotel.modelos.Producto;
import com.elsilencio.software_hotel.modelos.Reserva;
import com.elsilencio.software_hotel.modelos.Trabajador;
import com.elsilencio.software_hotel.servicios.ApiService;
import com.elsilencio.software_hotel.servicios.ClieService;
import com.elsilencio.software_hotel.servicios.HabiService;
import com.elsilencio.software_hotel.servicios.ProdService;
import com.elsilencio.software_hotel.servicios.TrabService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    ApiService api;

    @FXML
    private Button bntCrearHab;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnConfiguracion;

    @FXML
    private Button btnCrearClie;

    @FXML
    private Button btnCrearProd;

    @FXML
    private Button btnCrearResv;

    @FXML
    private Button btnCrearTrab;

    @FXML
    private Button btnEditarClie;

    @FXML
    private Button btnEditarHab;

    @FXML
    private Button btnEditarProd;

    @FXML
    private Button btnEditarResv;

    @FXML
    private Button btnEditarTrab;

    @FXML
    private Button btnEliminarClie;

    @FXML
    private Button btnEliminarHab;

    @FXML
    private Button btnEliminarProd;

    @FXML
    private Button btnEliminarResv;

    @FXML
    private Button btnEliminarTrab;

    @FXML
    private Button btnHabitacion;

    @FXML
    private Button btnPagoResv;

    @FXML
    private Button btnProducto;

    @FXML
    private Button btnReserva;

    @FXML
    private Button btnTrabajador;

    @FXML
    private TableColumn<Habitacion, String> colCaracHab;

    @FXML
    private TableColumn<Producto, String> colDescProd;

    @FXML
    private TableColumn<Cliente, String> colDniClie;

    @FXML
    private TableColumn<Cliente, String> colEmailClie;

    @FXML
    private TableColumn<Habitacion, String> colEstadoHab;

    @FXML
    private TableColumn<Trabajador, String> colEstadoTrab;

    @FXML
    private TableColumn<Cliente, String> colGenClie;

    @FXML
    private TableColumn<Cliente, Integer> colIdClie;

    @FXML
    private TableColumn<Habitacion, Integer> colIdHab;

    @FXML
    private TableColumn<Producto, Integer> colIdProd;

    @FXML
    private TableColumn<Trabajador, Integer> colIdTrab;

    @FXML
    private TableColumn<Cliente, String> colNombreClie;

    @FXML
    private TableColumn<Producto, String> colNombreProd;

    @FXML
    private TableColumn<Habitacion, String> colNumHab;

    @FXML
    private TableColumn<Trabajador, String> colPersonalTrab;

    @FXML
    private TableColumn<Habitacion, String> colPisoHab;

    @FXML
    private TableColumn<Habitacion, BigDecimal> colPrecioHab;

    @FXML
    private TableColumn<Producto, BigDecimal> colPrecioProd;

    @FXML
    private TableColumn<Trabajador, BigDecimal> colSueldoTrab;

    @FXML
    private TableColumn<Cliente, String> colTelefClie;

    @FXML
    private TableColumn<Habitacion, String> colTipoHab;

    @FXML
    private TableColumn<Producto, String> colUniProd;

    @FXML
    private TableColumn<Trabajador, String> colUsuarioTrab;

    @FXML
    private DatePicker fechaIResv;

    @FXML
    private DatePicker fechaSResv;

    @FXML
    private TabPane panelGeneral;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private SplitMenuButton splitDNIClie;

    @FXML
    private SplitMenuButton splitEstadoHab;

    @FXML
    private SplitMenuButton splitEstadoResv;

    @FXML
    private SplitMenuButton splitEstadoTrab;

    @FXML
    private SplitMenuButton splitGeneroClie;

    @FXML
    private SplitMenuButton splitTipoHab;

    @FXML
    private SplitMenuButton splitTipoResv;

    @FXML
    private SplitMenuButton splitUnidadProd;

    @FXML
    private TableView<Cliente> tablaCliente;

    @FXML
    private TableView<Habitacion> tablaHabitaciones;

    @FXML
    private TableView<Producto> tablaProducto;

    @FXML
    private TableView<Reserva> tablaReserva;

    @FXML
    private TableView<Trabajador> tablaTrabajador;
    @FXML
    private TextField txtApellidoMClie;

    @FXML
    private TextField txtApellidoPClie;

    @FXML
    private TextArea txtCaracteristicaHab;

    @FXML
    private TextField txtClienteResv;

    @FXML
    private TextField txtContraTrab;

    @FXML
    private TextField txtCostoResv;

    @FXML
    private TextArea txtDescripcionHab;

    @FXML
    private TextArea txtDescripcionProd;

    @FXML
    private TextArea txtDireccionClie;

    @FXML
    private TextField txtEmailClie;

    @FXML
    private TextField txtHabitacionResv;

    @FXML
    private TextField txtNombreClie;

    @FXML
    private TextField txtNombreProd;

    @FXML
    private TextField txtNumeroClie;

    @FXML
    private TextField txtNumeroHab;

    @FXML
    private TextField txtPersonalTrab;

    @FXML
    private TextField txtPisoHab;

    @FXML
    private TextField txtPrecioHab;

    @FXML
    private TextField txtPrecioProd;

    @FXML
    private TextField txtSueldoTrab;

    @FXML
    private TextField txtTelefonoClie;

    @FXML
    private TextField txtTrabajadorResv;

    @FXML
    private TextField txtUsuarioTrab;

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane.setOnMousePressed(this::iniciarArrastre);
        rootPane.setOnMouseDragged(this::hacerArrastre);

        api = new ApiService();

        TrabService.configurarTablaTrabajadores(colIdTrab, colPersonalTrab, colSueldoTrab, colUsuarioTrab,
                colEstadoTrab);
        HabiService.configurarTablaHabitaciones(colIdHab, colNumHab, colPisoHab, colPrecioHab, colEstadoHab, colTipoHab,
                colCaracHab);
        HabiService.listaHabitaciones(tablaHabitaciones);
        ProdService.configurarTablaProductos(colIdProd, colNombreProd, colPrecioProd, colUniProd, colDescProd);
        ClieService.configurarTablaCliente(colIdClie, colNombreClie, colDniClie, colGenClie, colTelefClie,
                colEmailClie);
    }

    @FXML
    void ComponenteClie(MouseEvent event) {
        try {
            panelGeneral.getSelectionModel().select(1);
            List<Cliente> allcliente = api.listar("cliente", Cliente[].class);
            tablaCliente.getItems().setAll(allcliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ComponenteConf(MouseEvent event) {

    }

    @FXML
    void ComponenteHab(MouseEvent event) {
        try {
            panelGeneral.getSelectionModel().select(0);
            List<Habitacion> allhabitacion = api.listar("habitacion", Habitacion[].class);
            tablaHabitaciones.getItems().setAll(allhabitacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ComponenteProd(MouseEvent event) {
        try {
            panelGeneral.getSelectionModel().select(2);
            List<Producto> allproducto = api.listar("producto", Producto[].class);
            tablaProducto.getItems().setAll(allproducto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ComponenteReser(MouseEvent event) {
        panelGeneral.getSelectionModel().select(3);
    }

    @FXML
    void ComponenteTrab(MouseEvent event) {
        try {
            panelGeneral.getSelectionModel().select(4);
            List<Trabajador> alltrabajador = api.listar("trabajador", Trabajador[].class);
            tablaTrabajador.getItems().setAll(alltrabajador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CRUD HABITACIONES

    @FXML
    void crearHabitaciones(MouseEvent event) {
        try {
            Habitacion hab = HabiService.agregarHab(txtNumeroHab, txtPisoHab, txtPrecioHab, splitEstadoHab,
                    splitTipoHab, txtCaracteristicaHab, txtDescripcionHab);
            api.crear("habitacion", hab, Habitacion.class);
            List<Habitacion> allhabitacion = api.listar("habitacion", Habitacion[].class);
            tablaHabitaciones.getItems().setAll(allhabitacion);
            HabiService.borrarHab(txtNumeroHab, txtPisoHab, txtPrecioHab, splitEstadoHab, splitTipoHab,
                    txtCaracteristicaHab, txtDescripcionHab);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void editarHabitaciones(MouseEvent event) {
        try {
            Habitacion seleccionada = tablaHabitaciones.getSelectionModel().getSelectedItem();
            Habitacion hab = HabiService.agregarHab(txtNumeroHab, txtPisoHab, txtPrecioHab, splitEstadoHab, splitTipoHab, txtCaracteristicaHab, txtDescripcionHab);
            api.actualizar("habitacion", seleccionada.getIdhabitacion(), hab, Habitacion.class);
            List<Habitacion> allhabitacion = api.listar("habitacion", Habitacion[].class);
            tablaHabitaciones.getItems().setAll(allhabitacion);
            HabiService.borrarHab(txtNumeroHab, txtPisoHab, txtPrecioHab, splitEstadoHab, splitTipoHab, txtCaracteristicaHab, txtDescripcionHab);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void eliminarHabitaciones(MouseEvent event) {
        Habitacion seleccionada = tablaHabitaciones.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            try {
                boolean eliminado = api.eliminar("habitacion", seleccionada.getIdhabitacion());
                if (eliminado) {
                    tablaHabitaciones.getItems().remove(seleccionada);
                    HabiService.borrarHab(txtNumeroHab, txtPisoHab, txtPrecioHab, splitEstadoHab, splitTipoHab, txtCaracteristicaHab, txtDescripcionHab);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void seleccionarItemHab(MouseEvent event) {
        HabiService.seleccionarHab(txtNumeroHab, txtPisoHab, txtPrecioHab, splitEstadoHab, splitTipoHab,
                txtCaracteristicaHab, txtDescripcionHab, tablaHabitaciones);
    }

    // CRUD CLIENTES

    @FXML
    void crearClientes(MouseEvent event) {
        try {
            Cliente clie = ClieService.agregarCli(txtNombreClie, txtApellidoMClie, txtApellidoPClie, splitDNIClie,txtNumeroClie, txtDireccionClie, txtTelefonoClie, txtEmailClie, splitGeneroClie);
            api.crear("cliente", clie, Cliente.class);
            List<Cliente> allcliente = api.listar("cliente", Cliente[].class);
            tablaCliente.getItems().setAll(allcliente);
            ClieService.borrarCli(txtNombreClie, txtApellidoMClie, txtApellidoPClie, splitDNIClie, txtNumeroClie,txtDireccionClie, txtTelefonoClie, txtEmailClie, splitGeneroClie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editarClientes(MouseEvent event) {
        try {
            Cliente seleccionada = tablaCliente.getSelectionModel().getSelectedItem();
            Cliente clie = ClieService.agregarCli(txtNombreClie, txtApellidoMClie, txtApellidoPClie, splitDNIClie, txtNumeroClie, txtDireccionClie, txtTelefonoClie, txtEmailClie, splitGeneroClie);
            clie.setIdpersona(seleccionada.getIdpersona());
            api.actualizar("persona", seleccionada.getIdpersona(), clie, Cliente.class);
            List<Cliente> allcliente = api.listar("cliente", Cliente[].class);
            tablaCliente.getItems().setAll(allcliente);
            ClieService.borrarCli(txtNombreClie, txtApellidoMClie, txtApellidoPClie, splitDNIClie, txtNumeroClie, txtDireccionClie, txtTelefonoClie, txtEmailClie, splitGeneroClie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void eliminarClientes(MouseEvent event) {
        Cliente seleccionada = tablaCliente.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            try {
                boolean eliminado = api.eliminar("cliente", seleccionada.getIdpersona());
                if (eliminado) {
                    tablaCliente.getItems().remove(seleccionada);
                    ClieService.borrarCli(txtNombreClie, txtApellidoMClie, txtApellidoPClie, splitDNIClie, txtNumeroClie, txtDireccionClie, txtTelefonoClie, txtEmailClie, splitGeneroClie);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    void seleccionarItemClien(MouseEvent event) {
        ClieService.seleccionarClie(txtNombreClie, txtApellidoMClie, txtApellidoPClie, splitDNIClie, txtNumeroClie, txtDireccionClie, txtTelefonoClie, txtEmailClie, splitGeneroClie, tablaCliente);
    }
    
    //CRUD PRODUCTOS
    @FXML
    void crearProducto(MouseEvent event) {
        try {
            Producto prod = ProdService.agregarProd(txtNombreProd, txtPrecioProd, splitUnidadProd, txtDescripcionProd);
            api.crear("producto", prod, Producto.class);
            List<Producto> allproducto = api.listar("producto", Producto[].class);
            tablaProducto.getItems().setAll(allproducto);
            ProdService.borrarProd(txtNombreProd, txtPrecioProd, splitUnidadProd, txtDescripcionProd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void editarProducto(MouseEvent event) {
        try {
            Producto seleccionada = tablaProducto.getSelectionModel().getSelectedItem();
            Producto prod = ProdService.agregarProd(txtNombreProd, txtPrecioProd, splitUnidadProd, txtDescripcionProd);
            prod.setIdproducto(seleccionada.getIdproducto());
            api.actualizar("producto", seleccionada.getIdproducto(), prod, Producto.class);
            List<Producto> allproducto = api.listar("producto", Producto[].class);
            tablaProducto.getItems().setAll(allproducto);
            ProdService.borrarProd(txtNombreProd, txtPrecioProd, splitUnidadProd, txtDescripcionProd);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    void eliminarProducto(MouseEvent event) {
        Producto seleccionada = tablaProducto.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            try {
                boolean eliminado = api.eliminar("producto", seleccionada.getIdproducto());
                if (eliminado) {
                    tablaProducto.getItems().remove(seleccionada);
                    ProdService.borrarProd(txtNombreProd, txtPrecioProd, splitUnidadProd, txtDescripcionProd);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void seleccionarItemProd(MouseEvent event) {
        ProdService.seleccionarProd(txtNombreProd, txtPrecioProd, splitUnidadProd, txtDescripcionProd, tablaProducto);
    }

    //CRUD TRABAJADOR
    @FXML
    void crearTrabajador(MouseEvent event) {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editarTrabajador(MouseEvent event) {

    }

    @FXML
    void eliminarTrabajador(MouseEvent event) {

    }

    @FXML
    void seleccionarItemTrab(MouseEvent event) {

    }

    @FXML
    private void seleccionarOpcion(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        SplitMenuButton parent = (SplitMenuButton) item.getParentPopup().getOwnerNode();
        parent.setText(item.getText());
    }

    @FXML
    void salirAplicacion(MouseEvent event) {
        Stage stage = (Stage) btnBorrar.getScene().getWindow();
        stage.close();
    }

    private void iniciarArrastre(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }

    private void hacerArrastre(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }
}
