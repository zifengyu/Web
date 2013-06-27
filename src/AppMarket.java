import java.io.FileWriter;
import java.io.IOException;

import javax.xml.ws.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppMarket {

	public static void downloadEoe(String url) {
		HttpClient client = new DefaultHttpClient();

		//String url = "http://www.eoemarket.com/download/149199_2.apk";
		HttpGet get = null;

		Document doc;
		for (int i = 0; i < 1; ++i)
			try {
				get = new HttpGet(url);
				HttpResponse response = client.execute(get);
				System.out.println(response.getEntity().getContentLength());


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (get != null)
					get.releaseConnection();
			}
	}

	public static void downloadMumayi(String url) {
		WebDriver driver = new FirefoxDriver();
		driver.get(url);

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("starlist")));
		WebElement element = driver.findElement(By.className("rank_now50"));
		element.click();


	}

	public static void main(String[] arges) {
		//downloadMumayi("http://www.mumayi.com/android-334409.html");
		
		
		for (int i = 0; i < 1234; ++i) {
			downloadEoe("http://down.mumayi.com/334409");
			downloadEoe("http://www.eoemarket.com/download/149199_2.apk");
			downloadEoe("http://api.gfan.com/market/api/apk?type=APK&cid=99&uid=-1&pid=2isBqNWM7meAP4DbTl/yPQ==&sid=pVqBbOFXdUgvQPc+3/xVOg==");
			downloadEoe("http://www.nduoa.com/apk/download/567454?from=ndoo");
		}
		


	}


}
