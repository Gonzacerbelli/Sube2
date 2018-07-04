package negocio;

import datos.RamalEstacion;

public class Facade {
	
	public BeneficioABM getBeneficioABM() {
		return new BeneficioABM();
	}
	
	public BoletoABM getBoletoABM() {
		return new BoletoABM();
	}
	public EstacionABM getEstacionABM() {
		return new EstacionABM();
	}
	public LineaABM getLineaABM() {
		return new LineaABM();
	}
	public RamalABM getRamalABM() {
		return new RamalABM();
	}

	public RedSubeABM getRedSubeABM() {
		return new RedSubeABM();
	}

	public TarifaABM getTarifaABM() {
		return new TarifaABM();
	}

	public TarjetaABM getTarjetaABM() {
		return new TarjetaABM();
	}

	public TransporteABM getTransporteABM() {
		return new TransporteABM();
	}

	public UsuarioABM getUsuarioABM() {
		return new UsuarioABM();
	}

	public UsuarioBeneficioABM getUsuarioBeneficioABM() {
		return new UsuarioBeneficioABM();
	}
	
	public UsuarioRolABM getUsuarioRolABM() {
		return new UsuarioRolABM();
	}
	
	public UsuarioDescuentoABM getUsuarioDescuentoABM() {
		return new UsuarioDescuentoABM();
	}

	public ViajeABM getViajeABM() {
		return new ViajeABM();
	}
	
	public MovimientoABM getMovimientoABM() {
		return new MovimientoABM();
	}

	public RamalEstacionABM getRamalEstacionABM() {
		return new RamalEstacionABM();
	}
}
