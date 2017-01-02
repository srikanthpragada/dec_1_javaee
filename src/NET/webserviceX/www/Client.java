package NET.webserviceX.www;

public class Client {

	public static void main(String[] args) throws Exception {
		GlobalWeatherSoapProxy proxy = new GlobalWeatherSoapProxy();
		System.out.println(proxy.getWeather("Delhi", "India"));
	}

}
