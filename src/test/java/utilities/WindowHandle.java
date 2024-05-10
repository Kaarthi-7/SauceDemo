package utilities;

import java.util.Set;

import factory.BaseClass;

public class WindowHandle {

	public void windowHandling() {
		String currentWindowId = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();
		for(String window: windows) {
			if(window.equals(currentWindowId)) {
				System.out.println("Changing Window Handle");
			}else {
				BaseClass.getDriver().switchTo().window(window);
			}
		}
	}
}
