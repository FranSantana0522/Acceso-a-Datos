package tarea5xml;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetasAct3 {
	
	ArrayList<RecetaAct3> lista=new ArrayList<RecetaAct3>();

	
	@Override
	public String toString() {
		return "RecetasAct3 [lista=" + lista + "]";
	}

	public RecetasAct3(ArrayList<RecetaAct3> lista) {
		this.lista = lista;
	}

	public ArrayList<RecetaAct3> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RecetaAct3> lista) {
		this.lista = lista;
	}
	
	
}
