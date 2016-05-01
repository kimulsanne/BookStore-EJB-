package com.kim.jaas;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.kim.model.User;
import com.kim.service.UserService;

/**
 * 
 * @author Dao
 */
public class SampleLoginModule implements LoginModule {
	private boolean isAuthenticated = false;
	private CallbackHandler callbackHandler;
	private Subject subject;
	private SamplePrincipal principal;

	public SampleLoginModule() {

	}

	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		System.out.println("initialize");
	}

	public boolean login() throws LoginException {
		try {
			NameCallback nameCallback = new NameCallback("username");
			PasswordCallback passwordCallback = new PasswordCallback(
					"password", false);

			Callback[] calls = new Callback[] { nameCallback, passwordCallback };

			this.callbackHandler.handle(calls);

			// 获得用户数据
			String username = nameCallback.getName();
			String password = String.valueOf(passwordCallback.getPassword());
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
		/*	User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserService userService = (UserService) context.lookup("ejb:/BookstoreWeb//UserServiceBean!com.kim.service.UserService");
			userService.login(user);*/
			// TODO验证，如：查询数据库、LDAP。。。
			System.out.println("login");
			if (true) 
			{
				this.principal = new SamplePrincipal(username);

				this.isAuthenticated = true;
			} else {
				throw new LoginException("user or password is wrong");
			}
		} catch (IOException e) {
			throw new LoginException("no such user");
		} catch (UnsupportedCallbackException e) {
			throw new LoginException("login failure");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.isAuthenticated;
	}

	/**
	 * 验证后处理，在Subject中加入用户对象
	 * 
	 * @return
	 * @throws javax.security.auth.login.LoginException
	 */
	public boolean commit() throws LoginException {
		System.out.println("commit");
		if (this.isAuthenticated) {
			this.subject.getPrincipals().add(this.principal);
		} else {
			throw new LoginException("Authentication failure");
		}

		return this.isAuthenticated;
	}

	public boolean abort() throws LoginException {
		System.out.println("abort");
		return false;
	}

	public boolean logout() throws LoginException {
		this.subject.getPrincipals().remove(this.principal);

		this.principal = null;
		System.out.println("logout");
		return true;
	}
}
