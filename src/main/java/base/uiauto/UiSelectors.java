package base.uiauto;

public enum UiSelectors {
    NEWUISELECTOR("new UiSelector()."),
    RESOURCEID("resourceId(\"%s\")"),
    CLASSNAME("className(\"%s\")"),
    TEXT("text(\"%s\")"),
    CHILDSELECTOR("childSelector(new UiSelector().%s)");

    private final String value;

    UiSelectors(String value) {
        this.value  = value;
    }

    public String getValue() {
        return value;
    }
}