package dados;

import java.util.GregorianCalendar;

public class HorasTrab {
	
	private GregorianCalendar dataTrab;
	private double horasTrab;
	
	public HorasTrab(GregorianCalendar dataTrab, double horasTrab) {
		this.dataTrab = dataTrab;
		this.horasTrab = horasTrab;
	}
	
	public GregorianCalendar getDataTrab() {
		return dataTrab;
	}
	public void setDataTrab(GregorianCalendar dataTrab) {
		this.dataTrab = dataTrab;
	}
	public double getHorasTrab() {
		return horasTrab;
	}
	public void setHorasTrab(double horasTrab) {
		this.horasTrab = horasTrab;
	}
	
}
