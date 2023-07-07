package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
			
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGScreenShots" + File.separator;
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "P@sswo0rd1!";

	public static final String DB_TEST_URL = "32.18.195.23:9860";
	public static final String DB_TEST_USER = "automationfc";
	public static final String DB_TEST_PASS = "P@sswo0rd1!";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAILED = 3;
	
	public static final String BROWSERSTACK_USERNAME = "kiettran_GmJgRy";
	public static final String BROWSERSTACK_ACCESSKEY = "JqkL7qAupXnx959Hp7UX";
	public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String LAMBDA_USERNAME = "takiet197";
	public static final String LAMBDA_ACCESSKEY = "88xCbyn3Ophwqoh5psESirkyeeUEgwgaPsr0hzE6GHfqYzPpw6";
	public static final String LAMBDA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_ACCESSKEY + "@hub.lambdatest.com/wd/hub";
	
	
	
}
