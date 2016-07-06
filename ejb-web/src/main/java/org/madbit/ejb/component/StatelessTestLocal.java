package org.madbit.ejb.component;

import javax.ejb.Local;

@Local
public interface StatelessTestLocal {
	
	public String sayHello();
	public int getNum();
	public void increaseNum();

}
