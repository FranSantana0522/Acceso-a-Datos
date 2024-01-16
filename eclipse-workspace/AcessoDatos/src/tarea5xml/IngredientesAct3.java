package tarea5xml;

public class IngredientesAct3 {
	private String cantidad;
	private String ingrediente;

	@Override
	public String toString() {
		return "IngredientesAct3 [cantidad=" + cantidad + ", ingrediente=" + ingrediente + "]";
	}

	public IngredientesAct3(String cantidad, String ingrediente) {
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

}
