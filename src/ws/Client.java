package ws;

public class Client {

	public static void main(String[] args) throws Exception {
		 
		HelloServiceProxy proxy = new HelloServiceProxy();
		System.out.println(proxy.getMessage());

	}

}
