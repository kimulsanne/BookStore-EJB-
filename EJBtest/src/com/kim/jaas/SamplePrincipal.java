package com.kim.jaas;

import java.security.Principal;

/**
 * 
 * @author Dao
 */
public class SamplePrincipal implements Principal {
	private String name;

	public SamplePrincipal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object ob) {
		System.out.println("SamplePrincipal");
		if (ob instanceof SamplePrincipal) {
			SamplePrincipal principal = (SamplePrincipal) ob;

			return this.name.equalsIgnoreCase(principal.getName());
		}

		return false;
	}

	public int hashCode() {
		return name.toUpperCase().hashCode();
	}
}
