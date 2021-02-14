package amazonHelper;

import org.testng.annotations.DataProvider;

public class DataPro {

    @DataProvider(name="input1")
    public Object[][] getData(){
        return new Object[][]{
                {"herainpandey@gmail.com","amazon@1988"},
                /*{"9717661012","himu@1988"}*/  //   If uncommented this line, then test will run two times
        };
    }

    @DataProvider(name="input2")
    public Object[][] getData1(){
        return new Object[][]{
                {"9717661012","himu@1988"}
        };
    }

}
