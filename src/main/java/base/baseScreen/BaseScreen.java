package base.baseScreen;

import base.elements.BaseElement;
import base.elements.IFactory;

public class BaseScreen {

    private BaseElement uniqueElement;

    public BaseScreen(BaseElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public IFactory getIFactory() {
        return new IFactory();
    }

    public boolean isDisplayed() {
        return uniqueElement.getElement().isDisplayed();
    }

    public boolean isEnabled() {
        return uniqueElement.getElement().isEnabled();
    }
}