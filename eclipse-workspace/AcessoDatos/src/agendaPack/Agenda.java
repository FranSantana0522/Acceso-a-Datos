package agendaPack;

import java.util.ArrayList;

public class Agenda {
	ArrayList agen=new ArrayList<Contacto>();

	@Override
	public String toString() {
		return "Agenda [agen=" + agen + "]";
	}

	public Agenda(ArrayList<Contacto> agen) {
		super();
		this.agen = agen;
	}

	public ArrayList<Contacto> getAgen() {
		return agen;
	}

	public void setAgen(ArrayList<Contacto> agen) {
		this.agen = agen;
	}
	
}
