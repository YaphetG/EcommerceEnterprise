package org.abyssinia.persitance.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
public class HibernateAwareObjectMapper extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
        Hibernate4Module hibernate4Module = new Hibernate4Module();
        registerModule(hibernate4Module);
    }	
}
