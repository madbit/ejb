package org.madbit.ejb.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;

import org.apache.log4j.Logger;

@Stateful(name="EJBTestStateful", mappedName="ejb/EJBTestStateful")
//@RolesAllowed({"user", "admin"})
public class StatefulTest implements StatefulTestLocal, StatefulTestRemote{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private int a;

	@PostConstruct
	public void postConstruct() {
		logger.debug("@PostConstruct");
		a = 0;
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.debug("@PreDestroy");
	}
	
	@PermitAll
	public String sayHello() {
		return "hello";
	}
	
	public int getNum() {
		return a;
	}
	
	public void increaseNum() {
		a++;
	}
}
