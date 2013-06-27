package waps;

import java.util.ArrayList;
import java.util.Random;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.params.HttpParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Ad {

	public static void main(String[] arges) {

		ArrayList<Client> list = Client.clientList;
		Random rand = new Random();

		for (int t = 0; t < 100000; ++t) {

			Client mobile = list.get(rand.nextInt(list.size()));
			//for (Client mobile : list) {

			HttpHost proxy = new HttpHost("127.0.0.1", 8888);
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

			CookieStore cookieStore = new BasicCookieStore();
			client.setCookieStore(cookieStore);
			//client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
			CookieSpecFactory csf = new CookieSpecFactory() {
				public CookieSpec newInstance(HttpParams params) {
					return new BrowserCompatSpec() {
						@Override
						public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
							// Oh, I am easy
							// allow all cookies
							//log.debug("custom validate");
						}
					};
				}
			};
			client.getCookieSpecs().register("easy", csf);
			client.getParams().setParameter(ClientPNames.COOKIE_POLICY, "easy"); 

			String url = "http://app.wapx.cn/action/connect/active?app_id=" +
					mobile.app_id +
					"&udid=" +
					mobile.udid +
					"&imsi=" +
					mobile.imsi +
					"&net=wifi&base=wapx.cn" +
					"&app_version=" +
					mobile.app_version +
					"&sdk_version=" +
					mobile.sdk_version +
					"&device_name=" +
					mobile.device_name +
					"&device_brand=" +
					mobile.device_brand +
					"&y=" +
					mobile.y +
					"&device_type=android" +
					"&os_version=" +
					mobile.os_version +
					"&country_code=CN&language=zh" +
					"&act=" +
					mobile.act +
					"&channel=" +
					mobile.channel +
					"&device_width=" +
					mobile.device_width +
					"&device_height=" +
					mobile.device_height +
					"&at=" + System.currentTimeMillis();

			HttpGet get = null;

			try {
				get = new HttpGet(url);
				HttpResponse response = client.execute(get);
				System.out.println(response.getStatusLine().getStatusCode() + " " + response.getEntity().getContentLength());				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (get != null)
					get.releaseConnection();
			}


			for (int i = 0; i < 32; ++i)
				try {
					url = "http://ads.wapx.cn/action/ad/show?" +
							"app_id=" +
							mobile.app_id +
							"&udid=" +
							mobile.udid +
							"&imsi=" +
							mobile.imsi +
							"&net=wifi&base=wapx.cn" +
							"&app_version=" +
							mobile.app_version +
							"&sdk_version=" +
							mobile.sdk_version +
							"&device_name=" +
							mobile.device_name +
							"&device_brand=" +
							mobile.device_brand +
							"&y=" +
							mobile.y +
							"&device_type=android" +
							"&os_version=" +
							mobile.os_version +
							"&country_code=CN&language=zh" +
							"&act=" +
							mobile.act +
							"&channel=" +
							mobile.channel +
							"&device_width=" +
							mobile.device_width +
							"&device_height=" +
							mobile.device_height;

					get = new HttpGet(url);
					HttpResponse response = client.execute(get);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						//System.out.println(response.getEntity());
						Document doc = Jsoup.parse(response.getEntity().getContent(), "UTF-8", "http://ads.wapx.cn/action/ad/show");
						if (doc.html().contains("imsi")) {
							Elements links = doc.select("a[href]");

							for (Element link : links) {
								url = link.attr("abs:href");
								if (url.contains("imsi")) {
									get = new HttpGet(url);
									response = client.execute(get);
									System.out.println(url);
									System.out.println(response.getEntity().getContentLength());
								}
							}
						}
					}
					Thread.sleep(33000);
				} catch (Exception e) {					
					e.printStackTrace();
				} finally {
					if (get != null)
						get.releaseConnection();
				}	
		}
		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		}
	}

}
