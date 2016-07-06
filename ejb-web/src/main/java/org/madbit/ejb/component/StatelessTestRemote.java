package org.madbit.ejb.component;

import javax.ejb.Remote;

@Remote
public interface StatelessTestRemote {
	
	public String sayHello();
	public int getNum();
	public void increaseNum();

}
