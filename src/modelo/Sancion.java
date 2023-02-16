package modelo;

public class Sancion {
	
	private int idSancion;
	private String descripcion;
	private float importe;

	public Sancion() {
	}
	
	
	public Sancion(String descripcion, float importe) {
		super();
		this.descripcion = descripcion;
		this.importe = importe;
	}


	public Sancion(int idSancion, String descripcion, float importe) {
		super();
		this.idSancion = idSancion;
		this.descripcion = descripcion;
		this.importe = importe;
	}

	public int getIdSancion() {
		return idSancion;
	}

	public void setIdSancion(int idSancion) {
		this.idSancion = idSancion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSancion;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sancion other = (Sancion) obj;
		if (idSancion != other.idSancion)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  descripcion + " - " + importe ;
	}
	
	

}
