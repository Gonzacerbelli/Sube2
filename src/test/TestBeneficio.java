package test;

import negocio.UsuarioABM;
import negocio.BeneficioABM;

import java.util.Calendar;
import java.util.GregorianCalendar;

import datos.Beneficio;

public class TestBeneficio {

	public static void main(String[] args) {


		UsuarioABM usuarioABM = new UsuarioABM();
		BeneficioABM BeneficioABM = new BeneficioABM();
		
		try 
		{
			GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance();
			String nombre = "Boleto Estudiantil";
			double valor = 300;
			
			int ultimoId = BeneficioABM.agregar(nombre, valor);
			System.out.println("Agregar Beneficio --" + ultimoId);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		try 
		{
			GregorianCalendar fechaHora = (GregorianCalendar) Calendar.getInstance();
			String nombre = "Boleto Estudiantil";
			double valor = 300;
			
			Beneficio beneficio = BeneficioABM.traerBeneficio(1);
			System.out.println("Traer Beneficio --" + beneficio.toString());
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		try 
		{
			String nombre = "Boleto Estudiantil";
			double valor = 300;
			
			Beneficio beneficio = BeneficioABM.traerBeneficio(1);
			System.out.println("Traer Beneficio --" + beneficio.toString());

			beneficio.setNombre("Estudiantil");
			BeneficioABM.modificar(beneficio);
			beneficio = BeneficioABM.traerBeneficio(1);
			System.out.println("Traer Beneficio --" + beneficio.toString());
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
		

	}

}
