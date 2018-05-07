package br.com.ic.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadorEvent extends ApplicationEvent {

	private static final long serialVersionUID = -3070877783527666975L;

	private HttpServletResponse response;
	private Long id;

	public RecursoCriadorEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;

	}

	public Long getId() {
		return id;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}
