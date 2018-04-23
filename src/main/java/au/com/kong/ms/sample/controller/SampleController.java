package au.com.kong.ms.sample.controller;

/**
 * @author Stephen Kong 
 * version 1.0
 * date    22/04/2018
 * 
 * This class defines the service API endpoints
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import au.com.kong.ms.sample.controller.bean.Node;
import au.com.kong.ms.sample.controller.service.SimpleService;
import au.com.kong.ms.sample.controller.utils.HttpHelper;

@RestController
@Component
public class SampleController {
	 
	@Autowired
	private HttpHelper httpHelper;
	
	@Autowired
	private SimpleService simpleService;

    @RequestMapping(value ="/",produces = "application/json")
    public String getRootUrlJson(HttpServletRequest request){
        String url = httpHelper.getUrl(request);
        Node node = simpleService.getNodeByUrl(url);
        String json =new Gson().toJson(node); 
        return json;
    }
    
    @RequestMapping(value ="/level1",produces = "application/json")
    public String getLevelOneUrlJson(HttpServletRequest request){
        String url = httpHelper.getUrl(request);
        Node node = simpleService.getNodeByUrl(url);
        String json =new Gson().toJson(node); 
        return json;
    }
    
    
}

