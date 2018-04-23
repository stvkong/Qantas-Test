package au.com.kong.ms.sample.controller.bean;

/**
 * @author Stephen Kong 
 * version 1.0
 * date    22/04/2018
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1286257599434720872L;
	//
	String url;
	String title;
	List<Node> nodes= new ArrayList<Node>();
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public Node getNodeByUrl(String url){
		
		if(getUrl().equals(url)){
			return this;
		}else{
			for(Node child:getNodes()){
				if(child.getNodeByUrl(url) != null){
					return child;
				}
			}
		}
		return null;
	}
	

}
