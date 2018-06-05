package datos;

public class TipoMovimiento {
	private int idTipoMovimiento;
	private String descripcion;
	
	public TipoMovimiento() {}

	public TipoMovimiento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
