package com.sample.Util;

import org.owasp.security.logging.mask.CRLFConverter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.web.util.HtmlUtils;

public class CustomCRLFConverter extends CRLFConverter{
	
	@Override
	protected String transform(ILoggingEvent event, String in) {
		//return Utils.replaceCRLFWithUnderscore(in);
		String input= super.transform(event,in);
		return HtmlUtils.htmlEscape(input);			
	}

}

