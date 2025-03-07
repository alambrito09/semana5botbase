package umg.principal;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import umg.principal.Bottelegram.Bot;
import umg.principal.Bottelegram.db.DatabaseConnection;
import umg.principal.Bottelegram.model.User;
import umg.principal.Bottelegram.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static void PruebaInsertaUsuario() {
        //explicación:
        // 1. Servicio
        //Servicio (UserService.java):
        //La clase UserService actúa como intermediario entre el controlador y la capa de acceso a datos (DAO).
        // Se encarga de la lógica de negocio, validaciones y de coordinar las transacciones.
        // 2. DAO
        //Capa de Acceso a Datos (UserDao.java):
        //Esta clase contiene los métodos para interactuar con la base de datos, usando la
        // conexión proporcionada por DatabaseConnection. Aquí es donde se construyen y ejecutan
        // las consultas SQL.
        // 3. Conexión a la Base de Datos
        //Gestión de la Conexión (DatabaseConnection.java):
        //Esta clase es responsable de proporcionar la conexión a la base de datos. Puede leer la configuración
        // desde un archivo de propiedades (application.properties) para obtener los detalles de conexión.
        // 4. Transacciones
        //Gestión de Transacciones (TransactionManager.java):
        //Esta clase se encarga de iniciar, confirmar o revertir transacciones en la base de datos.
        // Se utiliza para agrupar varias operaciones en una sola transacción y garantizar la integridad de los datos.
        // 5. Modelo (User.java):
        //La clase User representa la estructura de los datos que se insertan en la base de datos.
        // Es una clase POJO (Plain Old Java Object) con atributos, getters y setters.

        //invoca el servicio que manejará la lógica de negocio.
        UserService userService=new UserService();
        User user = new User();

        // Crear un nuevo usuarioUseruser=newUser();
        user.setCarne("09052315264");
        user.setNombre("alan Lopez");
        user.setCorreo("ALopez@gmail.com");
        user.setSeccion("A");
        user.setTelegramid(1234567890L);
        user.setActivo("Y");

        try {
            userService.createUser(user);
            System.out.println("User created successfully!");
        } catch (SQLException e) {
            System.out.println("hay clavos!!");
            e.printStackTrace();
        }
    }

    private static void PruebaActualizacionUsuario() {
        UserService servicioUsuaio = new UserService();

        User usurioObtenido;
        //obtener información del usuario por correo electrónico
        try {
            usurioObtenido = servicioUsuaio.getUserByEmail("ALopez@gmail.com");
            System.out.println("Retrieved User: " + usurioObtenido.getNombre());
            System.out.println("Retrieved User: " + usurioObtenido.getCorreo());
            System.out.println("Retrieved User: " + usurioObtenido.getId());

            //actualizar información del usuario
            //usurioObtenido.setCarne("0905-12-12345");
           // usurioObtenido.setNombre("Andrea Ascoli");
            //usurioObtenido.setCorreo("anAscoli@gmail.com");
            //usurioObtenido.setSeccion("A");
            //usurioObtenido.setTelegramid(1234567890L);
            //usurioObtenido.setActivo("Y");

            servicioUsuaio.updateUser(usurioObtenido);
            System.out.println("User updated successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void PruebaAbuscarporcarne() {
        UserService servicioUsuaio = new UserService();

        User usurioObtenido;
        //obtener información del usuario por carne
        try {
            usurioObtenido = servicioUsuaio.getUserBycarne("09052315264");
            System.out.println("carne encontrado");
            System.out.println("Retrieved User: " + usurioObtenido.getNombre());
            System.out.println("Retrieved User: " + usurioObtenido.getCorreo());
            System.out.println("Retrieved User: " + usurioObtenido.getId());



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void PruebaAbuscarporid() {
        UserService servicioUsuaio = new UserService();

        User usurioObtenido;
        //obtener información del usuario por id
        try {
            usurioObtenido = servicioUsuaio.getUserById(7);
            System.out.println("id encontrado");
            System.out.println("Retrieved User: " + usurioObtenido.getNombre());
            System.out.println("Retrieved User: " + usurioObtenido.getCorreo());



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void PruebaEliminarUsuario() {
        UserService servicioUsuaio = new UserService();
        try {
            servicioUsuaio.deleteUserByEmail("ALopez@gmail.com");
            System.out.println("User deleted successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
    public static void main(String[] args) {

       // PruebaInsertaUsuario();
PruebaAbuscarporcarne();
PruebaAbuscarporid();
       // PruebaActualizacionUsuario();
// Crea una instancia de TelegramBotsApi
        //PruebaEliminarUsuario();
        TelegramBotsApi botsApi;

        try {
            // Inicializa TelegramBotsApi con una sesión por defecto
            botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Registra tu bot
            botsApi.registerBot(new Bot());

            System.out.println("Bot registrado y funcionando...");

        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el bot: " + e.getMessage());
        }

    }


    }
