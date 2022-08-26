package base.uiauto;

public class AndroidUIAuto {

    public static String createAUISelector(SelectorObject ... selector) {
        switch(selector.length) {
            case 0: {
                return selector[0].getSelector();
            }
            default: {
                StringBuilder trueSelector = new StringBuilder();
                for(int i = 0;i<selector.length;i++) {
                    if(i==0) {
                        trueSelector.append(selector[i].getSelector());
                    } else {
                        trueSelector.append(".").append(selector[i].getSelector());
                    }
                }
                return trueSelector.toString();
            }
        }
    }

    public static String createAUIScrollable(String existUISelector) {
        return String.format(UiScrollables.SCROLL_INTO_VIEW.getValue(), existUISelector);
    }
}