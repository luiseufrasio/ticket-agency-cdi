package com.packtpub.wflydevelopment.chapter4.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

public class FacesContextProducer {

	@Produces
	@RequestScoped
	public FacesContext produceFacesContext(InjectionPoint injectionPoint) {
		return FacesContext.getCurrentInstance();
	}
}
