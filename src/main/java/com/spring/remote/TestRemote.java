package com.spring.remote;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class TestRemote {
	
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public AccountService getAccountService() {
		return accountService;
	}




	public static void main(String[] args) {
		
		Resource res = new FileSystemResource("D:\\workspace\\TestIdea\\src\\invoker-client.xml");
		BeanFactory beanFactory = new XmlBeanFactory(res); 
	
		AccountService test = (AccountService)beanFactory.getBean("accountServiceRemoteProxy");
		System.out.println(test.getAccounts("test"));
	}

}
