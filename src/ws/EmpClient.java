package ws;

public class EmpClient {

	public static void main(String[] args) throws Exception {
		 
		EmployeeServiceProxy proxy = new EmployeeServiceProxy();
		Employee e = proxy.getDetails("105");
		System.out.println( e.getName());

	}

}
