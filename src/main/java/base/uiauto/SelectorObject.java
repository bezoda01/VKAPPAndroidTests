package base.uiauto;

public class SelectorObject {

    private String selector;

    public SelectorObject(UiSelectors method, String value) {
        selector = String.format(method.getValue(), value);
    }

    public String getSelector() {
        return selector;
    }
}
