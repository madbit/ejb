package org.madbit.ejb.component;

import javax.ejb.Local;

@Local
public interface StatefulTestLocal {
	
	public String sayHello();
	public int getNum();
	public void increaseNum();

}
