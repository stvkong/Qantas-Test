package au.com.kong.ms.sample.controller.utils;

/**
 * @author Stephen Kong 
 * version 1.0
 * date    22/04/2018
 * 
 * as its name indicates, this is a temp class used for demo purpose. It creates a temp data
 * which will be consumed by service.
 *
 */
import au.com.kong.ms.sample.controller.bean.Node;

public class TmpDataStore {
	
	//
	private Node node;
	
	private static TmpDataStore instance;
	
	private TmpDataStore(){
		init();
	}
	
	public static TmpDataStore getInstance(){
		if(instance==null){
			 synchronized (TmpDataStore.class) {
				 if(instance == null)
					 instance= new TmpDataStore();
			 }
		}
		return instance;
	}
	
	private void init(){
		node = new Node();
		node.setTitle("root");
		node.setUrl("http://localhost/");
		
		Node node2 = new Node();
		node2.setTitle("Level 1 Page");
		node2.setUrl("http://localhost/level1");
		node.addNode(node2);
		
		
		Node node1 = new Node();
		node1.setTitle("Some Site 1");
		node1.setUrl("http://some-site.com/");
		node2.addNode(node1);
		
		
		Node node3 = new Node();
		node3.setTitle("Google page 1");
		node3.setUrl("http://goole.com/page1");
		node.addNode(node3);
		
	}

	public Node getNode() {
		return node;
	}
	
	public Node getNodeByUrl(String url){
		//
		return node.getNodeByUrl(url);
	}

	
}
