package tarea5xml;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaAct3 {

	private String titulo;
	ArrayList<IngredientesAct3> ingredientes=new ArrayList<IngredientesAct3>();
	private String procedimiento;
	private String tiempo;


	@Override
	public String toString() {
		return "RecetaAct3 [titulo=" + titulo + ", ingredientes=" + ingredientes + ", procedimiento=" + procedimiento
				+ ", tiempo=" + tiempo + "]";
	}

	public RecetaAct3(String titulo, ArrayList<IngredientesAct3> ingredientes, String procedimiento, String tiempo) {
		this.titulo = titulo;
		this.ingredientes = ingredientes;
		this.procedimiento = procedimiento;
		this.tiempo = tiempo;
	}

	public ArrayList<IngredientesAct3> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<IngredientesAct3> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

}
