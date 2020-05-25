package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import DTO.VueloDTO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;
import EasyBooking.LP.Entrar_Registrar;
import Remote.ServiceLocator;

public class Controller {
	
	private ServiceLocator rsl = null;
	
	public Controller() throws RemoteException 
	{
		
		rsl = new ServiceLocator();
		rsl.setService();
//		new Entrar_Registrar(this);
	}
	//Falta la implementacion de todos los métodos de la fachada así
	public List<VueloDTO> getVuelos() throws RemoteException {
		
		return rsl.getService().getVuelos();
	}

	public ArrayList<Aeropuerto> getAeropuertos() {
		System.out.println("HOLA 4");
		
		
		ArrayList<Aeropuerto> lista=null;
		try {
			lista = rsl.getService().getAeropuertos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("aqui fallas!!!!!!!");
			e.printStackTrace();
			System.out.println(" sisi todo la shit que pone arriba es del catch del controller guapa");
		}
		
		System.out.println("CONTROLLER"+lista.get(0).getNomAeropuerto());
		return lista;
	}

	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada) throws RemoteException {
		rsl.getService().newReserva(Aeropuerto_Salida, Aeropuerto_llegada);
	}

	public void Pagar(double precio, String cod_vuelo) throws RemoteException {
		rsl.getService().Pagar(precio, cod_vuelo);
		
	}

	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, Date fecha)  throws RemoteException {
		return rsl.getService().Buscar_vuelos(origen, destino, fecha);
	}

	public void AplicarFiltro(String hora_ida_min, String hora_ida_max, String hora_vuelta_min,String hora_vuelta_max, double min_precio, double max_precio, double min_dur, double max_dur) throws RemoteException {
		rsl.getService().AplicarFiltro(hora_ida_min, hora_ida_max, hora_vuelta_min,hora_vuelta_max, min_precio, max_precio, min_dur,max_dur);
	}
	
	public void RegistrarUsuario(String nom, String ape, String email, String password) throws RemoteException
	{
		rsl.getService().RegistrarUsuario(nom, ape, email, password);
	}
	public boolean  LogInUsuario(String email, String contrasena) throws RemoteException
	{
		return rsl.getService().LogInUsuario(email, contrasena);
	}

	
}
