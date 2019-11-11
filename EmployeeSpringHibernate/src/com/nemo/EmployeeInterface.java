package com.nemo;

import java.util.Iterator;

public interface EmployeeInterface {
	
	public Iterator getEmployeeNames();
	public void storeToDb(Employee e);

}
