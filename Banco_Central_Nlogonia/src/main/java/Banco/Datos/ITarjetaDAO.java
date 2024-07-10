package Banco.Datos;

import java.util.List;
import Banco.Entidad.Tarjeta.Tarjeta;

public interface ITarjetaDAO {
    List<Tarjeta> obtenerTarjetas();
    void guardarTarjeta(Tarjeta tarjeta);
    void eliminarTarjeta(Tarjeta tarjeta);
    List<Tarjeta> obtenerTarjetaPorCliente(int id);
}
