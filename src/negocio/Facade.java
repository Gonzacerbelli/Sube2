package negocio;

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

	public ViajeABM getViajeABM() {
		return new ViajeABM();
	}
}
