package au.com.kong.ms.sample.controller.utils;

/**
 * @author Stephen Kong 
 * version 1.0
 * date    22/04/2018
 * 
 * This help class specify http related common operations used by all across the project.
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component("httpHelper")
public class HttpHelper {
	
	 /**
     * 
     * @param request
     * @return url string, but without the port.
     */
    public String getUrl(HttpServletRequest request){
    	return  request.getScheme() + "://" +   
                request.getServerName() + 
                request.getRequestURI();
    }

}
