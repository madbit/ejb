package org.madbit.ejb.component;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Main {

	public static void main(String[] args) {
		try
		{
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			props.put(Context.SECURITY_PRINCIPAL, "paperino"); 
			props.put(Context.SECURITY_CREDENTIALS, "paperino"); 
			Context context = new InitialContext(props);
			System.out.println("Initial Context created");

			StatelessTestRemote statelessTest;
			statelessTest = (StatelessTestRemote) context.lookup("ejb/EJBTestStateless");
			System.out.println(statelessTest.sayHello());
			System.out.println(statelessTest.getNum());
			statelessTest.increaseNum();
			System.out.println(statelessTest.getNum());
			
			StatefulTestRemote statefulTest;
			statefulTest = (StatefulTestRemote) context.lookup("ejb/EJBTestStateful");
			System.out.println(statefulTest.sayHello());
			System.out.println(statefulTest.getNum());
			statefulTest.increaseNum();
			System.out.println(statefulTest.getNum());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
