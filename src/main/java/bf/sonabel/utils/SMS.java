package bf.sonabel.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMS {

	public static void main(String[] args) {
		SMS s = new SMS();
		System.out.println((s.sendSms("212648271224","Test de Mindtech" )));
	}
	public String sendSms(String num, String msg) {
		try {
			// Construct data
			String apiKey = "apikey=" + "nCSHgEoBb6o-O2vuTMa2piSH856w1qY3ZBx666g4t8";
			String message = "&message=" + msg ;
			String sender = "&sender=" + "SonabelAuto";
			String numbers = "&numbers=" + num;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
