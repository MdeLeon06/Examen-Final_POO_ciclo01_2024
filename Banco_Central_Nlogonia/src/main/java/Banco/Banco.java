package Banco;

import Banco.Datos.ClienteDAO;
import Banco.Datos.FacilitadorDAO;
import Banco.Datos.UsuarioDAO;
import Banco.Entidad.Cliente.Cliente;
import Banco.Entidad.Facilitador.Facilitador;
import Banco.Entidad.Tarjeta.Tarjeta;
import Banco.Entidad.Usuario.Usuario;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        FacilitadorDAO facilitadorDAO = new FacilitadorDAO();
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        Tarjeta tarjeta = new Tarjeta();
        Facilitador facilitador = new Facilitador();
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        while (opcion!=3) {
            System.out.println("1- Crear cuenta\n2- Listar cuenta\n3- Salir\nIndique la opcion:");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del usuario: ");
                    String Usuario = sc.next();
                    System.out.println("Ingrese la clave del usuario: ");
                    String Clave = sc.next();
                    System.out.println("Ingrese el nombre Completo: ");
                    String Nombre = sc.next();
                    System.out.println("Ingrese la direccion: ");
                    String Direccion = sc.next();
                    System.out.println("Ingrese la telefono: ");
                    String Telefono = sc.next();
                    System.out.println("Ingrese el numero cuenta bancaria: ");
                    String NumeroCuenta = sc.next();
                    System.out.println("Ingrese el facilitador de la tarjeta: ");
                    String Facilitador = sc.next();
                    System.out.println("Ingrese la fecha de expiriacion (AAAA-MM-DD): ");
                    String FechaExpiriacion = sc.next();
                    System.out.println("Ingrese el tipo de tarjeta: ");
                    String TipoTarjeta = sc.next();
                    usuario.setUsuario(Usuario);
                    usuario.setClave(Clave);
                    cliente.setNombre(Nombre);
                    cliente.setDireccion(Direccion);
                    cliente.setTelefono(Telefono);
                    tarjeta.setTarjeta(NumeroCuenta);
                    tarjeta.setFechExpiarion(FechaExpiriacion);
                    tarjeta.setTipoTarjeta(TipoTarjeta);
                    int id = facilitadorDAO.BuscarFacilitador(Facilitador);
                    tarjeta.setId_Facilitador(id);
                    int idCliente =clienteDAO.conseguirIdCliente(cliente);
                    tarjeta.setId_Cliente(idCliente);
                    usuario.setId_Cliente(idCliente);

            }
        }
    }
}
