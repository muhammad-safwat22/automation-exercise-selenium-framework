package base;

import seleniumFramework.SeleniumFrameWork;

/**
 * Base class for all Page Objects. Holds the shared Selenium framework
 * instance.
 */
public class PageBase {

	protected SeleniumFrameWork FW;

	public PageBase(SeleniumFrameWork FW) {
		this.FW = FW;
	}

}