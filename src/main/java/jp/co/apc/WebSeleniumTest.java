package jp.co.apc;

import org.jsoup.Jsoup;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebSeleniumTest {

	// use proxy -> true.
	private static final boolean PROXY_USE = false;
	private static final String PROXY = "proxy.xxxx.jp:8080";

	private static final String JSESSIONID = "jsessionid";
	private static final String TELNO = "telNo";
	private static final String BUTTON = "buttonMiddle";
	private static final String TOP_REDIRECT = "https://www.web171.jp/web171app/topRedirect.do?english";
	private static final String CONTENTS_FORM = "contentsForm";
	private static final String FINE = "I'm fine .";

	public static void main(String[] args) {
		try {
			new WebSeleniumTest().execute("0904961xxxx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute(final String number) {
		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		driver.setProxySettings(PROXY_USE ? this.createProxy() : null);
		driver.get(TOP_REDIRECT);
		driver.manage().addCookie(this.createCookie(driver.getPageSource()));
		driver.findElementsByName(TELNO).get(0).sendKeys(number);
		driver.findElementsByClassName(BUTTON).get(1).click();

		if (0 < Jsoup.parse(driver.getPageSource()).getElementsByClass(CONTENTS_FORM).get(1).toString().indexOf(FINE)) {
			System.out.println(number + " is FINE.");
		} else {
			System.out.println(number + " is DEAD.");
		}
		driver.quit();
	}

	Proxy createProxy() {
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(PROXY);
		proxy.setSslProxy(PROXY);
		proxy.setFtpProxy(PROXY);
		return proxy;
	}

	Cookie createCookie(final String source) {
		int i = source.indexOf(JSESSIONID);
		return new Cookie(JSESSIONID, source.substring(i + 11, i + 51));
	}
}
