package org.madbit.ejb.component;

import javax.jws.WebService;

@WebService(targetNamespace = "http://madbit.org/wsdl")
public interface StatelessTestSOAP {
	
	public String sayHello();
	public int getNum();
	public void increaseNum();

}
