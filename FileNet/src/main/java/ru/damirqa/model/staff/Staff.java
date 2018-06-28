package ru.damirqa.model.staff;

public abstract class Staff {
	
	private int id;
	
	@Override
	public String toString() {
		return "Элемент организационной структуры " + this.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
