package com.techelevator.capstone.security;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter implements Filter {
	
	private static final List<String> PROVIDER_URLS = Arrays.asList( "" );
	private static final List<String> PATIENT_URLS = Arrays.asList( "patientScheduling" );

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		Integer providerId = getProviderIdFromSession(httpRequest);
		Integer patientId = getPatientIdFromSession(httpRequest);
		String pageName = getPageName(httpRequest);
		
		if(PROVIDER_URLS.contains(pageName)) {
			if(providerId == null && patientId == null) {
				redirectToLoginPage(httpRequest, httpResponse);
			} else if(patientId != null) {
				httpResponse.sendError(403);
			}
		} else if(PATIENT_URLS.contains(pageName)) {
			if(providerId == null && patientId == null) {
				redirectToLoginPage(httpRequest, httpResponse);
			} else if(providerId != null) {
				httpResponse.sendError(403);
			}
		}

		chain.doFilter(request, response);
	}

	private void redirectToLoginPage(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws IOException {
		
		String originalRequest = httpRequest.getRequestURL().toString();
		String queryString = httpRequest.getQueryString();
		if(queryString != null) {
			originalRequest = originalRequest + "?" + queryString;
		}
		
		String context = httpRequest.getServletContext().getContextPath();
		httpResponse.sendRedirect(context+"/patientLogin?destination="+URLEncoder.encode(originalRequest, "UTF-8"));
		httpResponse.sendRedirect(context+"/");
	}

	private Integer getProviderIdFromSession(HttpServletRequest httpRequest) {
		return (Integer)httpRequest.getSession().getAttribute("currentDoctorId2");
	}
	
	private Integer getPatientIdFromSession(HttpServletRequest httpRequest) {
		return (Integer)httpRequest.getSession().getAttribute("currentPatientId2");
	}

	private String getPageName(HttpServletRequest httpRequest) {
		String[] path = httpRequest.getServletPath().split("/");
		if(path.length >= 2) {
			return path[1];
		} else {
			return null;
		}
	}

	@Override
	public void destroy() {
		
	}

}
