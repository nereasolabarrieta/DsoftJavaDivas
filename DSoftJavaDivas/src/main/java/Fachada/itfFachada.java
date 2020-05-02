package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;

public interface itfFachada extends Remote{
	
	public List<Vuelo> getVuelos()throws RemoteException;//ese vuelo luego habra que convertirlo en DTOVuelo
	public List<Aeropuerto> getAeropuerto()throws RemoteException;//ese vuelo luego habra que convertirlo en DTOVuelo
	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada)throws RemoteException;
	public void Pagar(double precio, String cod_vuelo)throws RemoteException;
	public void Buscar(String origen, String destino, Date fecha);
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio);
}
