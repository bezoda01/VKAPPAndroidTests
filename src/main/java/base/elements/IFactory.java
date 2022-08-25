package base.elements;

import org.openqa.selenium.By;
import java.util.List;

public class IFactory {

    public TextField getTextField(By locator, String message) {
        return new TextField(locator, message);
    }

    public List<TextField> getTextFields(By locator, String message) {
        return new TextField(locator, message).getElements(TextField.class);
    }

    public Button getButton(By locator, String message) {
        return new Button(locator, message);
    }

    public List<Button> getButtons(By locator, String message) {
        return new Button(locator, message).getElements(Button.class);
    }
}