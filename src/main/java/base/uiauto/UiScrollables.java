package base.uiauto;

public enum UiScrollables {

    SCROLL_INTO_VIEW("new UiScrollable("+UiSelectors.NEWUISELECTOR.getValue()+"scrollable(true)).scrollIntoView("+UiSelectors.NEWUISELECTOR.getValue()+"%s)");

    private final String value;

    UiScrollables(String value) {
        this.value  = value;
    }

    public String getValue() {
        return value;
    }
}