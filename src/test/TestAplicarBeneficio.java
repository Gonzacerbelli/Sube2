package test;

import datos.Usuario;
import datos.UsuarioBeneficio;
import datos.Viaje;
import datos.Boleto;
import datos.Estacion;
import datos.Linea;
import datos.Movimiento;
import datos.Ramal;
import datos.RedSube;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Terminal;
import datos.Transporte;
import negocio.BoletoABM;
import negocio.Facade;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;


public class TestAplicarBeneficio {

	public static void main(String[] args) {

		try 
		{
			Facade f = new Facade();
			//estos parametros los manda el usuario a traves del controlador
			int idTransporte = 1;
			int numTarjeta = 1234;
			int idLinea = 1;
			int idTarifa = 1;
			
			Tarjeta tarjeta = f.getTarjetaABM().traerTarjetaPorNum(numTarjeta);
			System.out.println("Tarjeta -->" + tarjeta);
			Terminal terminal = new Terminal("Banfield");
			if(tarjeta.getUsuario() == null) {
				throw new Exception("No hay usuario asignado");
			}
			Set<UsuarioBeneficio> usuarioBeneficios = f.getUsuarioBeneficioABM().traerUsuarioBeneficios(tarjeta.getUsuario().getIdUsuario());
			f.getBeneficioABM().aplicarBeneficios(tarjeta, usuarioBeneficios, terminal);
			System.out.println("Tarjeta recargada -->" + tarjeta);
		} 
		catch (Exception e)  
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		

	}

}
