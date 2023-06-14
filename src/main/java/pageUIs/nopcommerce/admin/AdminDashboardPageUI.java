package pageUIs.nopcommerce.admin;

public class AdminDashboardPageUI {
	public static final String DASHBOARD_HEADER = "xpath=//h1[contains(text(), 'Dashboard')]";
	public static final String NAVIGATE_TAB = "xpath=//p[contains(text(), '%s')]/parent::a/parent::li[contains(@class, 'has-treeview')]/a";
	public static final String NAVIGATE_LINK = "xpath=//a[contains(@href, '/%s/')]";
}
