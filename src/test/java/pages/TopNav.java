package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class TopNav extends ReusableMethods {

    public TopNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

}
