package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class LeftNav extends ReusableMethods {

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

}
