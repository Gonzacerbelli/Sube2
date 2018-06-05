package test;

import datos.Usuario;
import datos.Viaje;
import datos.Usuario;
import datos.Beneficio;
import datos.Movimiento;
import negocio.BeneficioABM;
import negocio.UsuarioABM;
import negocio.UsuarioBeneficioABM;
import negocio.UsuarioABM;
import negocio.ViajeABM;

import java.util.Set;



public class TestAgregarUsuarioBeneficio {

	public static void main(String[] args) {

		try 
		{
			UsuarioABM tABM = new UsuarioABM();
			Usuario usuario = tABM.traerUsuario(39281276);
			BeneficioABM bABM = new BeneficioABM();
			bABM.agregar("Boleto Estudiantil", 300);
			Beneficio beneficio = bABM.traerBeneficio(6);
			UsuarioBeneficioABM ubABM = new UsuarioBeneficioABM();
			ubABM.agregar(usuario, beneficio);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		

	}

}
