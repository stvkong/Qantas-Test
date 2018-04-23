package au.com.kong.ms.sample.controller.service;

/**
 * @author Stephen Kong 
 * version 1.0
 * date    22/04/2018
 * 
 * A service class which performs the business process.
 */

import org.springframework.stereotype.Component;

import au.com.kong.ms.sample.controller.bean.Node;
import au.com.kong.ms.sample.controller.utils.TmpDataStore;

@Component("simpleService")
public class SimpleService {
	
	public Node getNodeByUrl(String url){
		return TmpDataStore.getInstance().getNodeByUrl(url);
	}

}
