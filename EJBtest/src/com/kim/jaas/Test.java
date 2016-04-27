package com.kim.jaas;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String username = "username";
			String password = "password";

			// 此处指定了使用配置文件的“Sample"验证模块，对应的实现类为SampleLoginModule
			LoginContext lc = new LoginContext("Sample",
					new SampleCallbackHandler(username, password));

			// 进行登录操作，如果验证失败会抛出异常
			lc.login();
			System.out.println("ok");
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

}
