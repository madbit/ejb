package org.madbit.ejb.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;

@Stateless(name="EJBTestStateless", mappedName="ejb/EJBTestStateless")
//@RolesAllowed({"admin"})
@WebService(
        portName = "StatelessTestPort",
        serviceName = "StatelessTestService",
        targetNamespace = "http://madbit.org/wsdl",
        endpointInterface = "org.madbit.ejb.component.StatelessTestSOAP")
// WSDL exposed on http://localhost:8080/StatelessTestService/StatelessTest?wsdl

public class StatelessTest implements StatelessTestLocal, StatelessTestRemote, StatelessTestSOAP {
	
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
