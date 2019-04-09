package com.liujie.mvc.resolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class viewResolverBySuffix implements ViewResolver{

	Logger log = LoggerFactory.getLogger(viewResolverBySuffix.class);
	
	
	@Override
	 public View resolveViewName(String viewName, Locale locale) throws Exception {
			log.info(" ---------------- 加载 viewResolverBySuffix ！--------------------");
	       for(Map.Entry<Set<String>, ViewResolver> map : viewResolverMap.entrySet()){
	           Set<String> suffixs = map.getKey();
	           for(String suffix : suffixs){
	               if (viewName.endsWith(suffix)){
	                   ViewResolver viewResolver = map.getValue();
	                   if(null != viewResolver){
	                	   log.info("viewResolver is not null");
	                       log.info("found viewResolver '" + viewResolver + "' for viewName '" + viewName+ "'");
	                       return viewResolver.resolveViewName(viewName, locale);
	                   }
	               }
	           }
	       }
	       
	       if(defaultViewResolver != null){
	    	   log.info("defaultViewResolver is null");
	           return defaultViewResolver.resolveViewName(viewName, locale);
	       }
	       // to allow for ViewResolver chaining
	       log.info("return null");
	       return null;
	    }
	    
	    private Map<Set<String>,ViewResolver> viewResolverMap = new HashMap<Set<String>,ViewResolver>();
	    
	    private ViewResolver defaultViewResolver = null;

	    public Map<Set<String>, ViewResolver> getViewResolverMap() {
	        return viewResolverMap;
	    }

	    public void setViewResolverMap(Map<Set<String>, ViewResolver> viewResolverMap) {
	        this.viewResolverMap = viewResolverMap;
	    }

	    public ViewResolver getDefaultViewResolver() {
	        return defaultViewResolver;
	    }

	    public void setDefaultViewResolver(ViewResolver defaultViewResolver) {
	        this.defaultViewResolver = defaultViewResolver;
	    }

}
