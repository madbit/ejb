package org.madbit.ejb.component;

import javax.ejb.Remote;

@Remote
public interface StatefulTestRemote {
	
	public String sayHello();
	public int getNum();
	public void increaseNum();

}
