package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.DogAPIPage;


public class TC04_DogAPI extends Base {

    public TC04_DogAPI(){
        super();
    }
    public WebDriver driver;
    public DogAPIPage dogAPIPage = new DogAPIPage(null);
    @Test(priority = 1)
    public void performAnAPIRequestToProduceListOfAllDogBreeds()
    {
        dogAPIPage.PerformAnAPIRequestToProduceListOfAllDogBreeds();
    }

    @Test(priority = 2)
    public void usingCodeToVerifySearchRetrieverBreedIsWithinTheList()
    {
        dogAPIPage.UsingCodeToVerifySearchRetrieverBreedIsWithinTheList();
    }

    @Test(priority = 3)
    public void performRequestToProducelistOfSubBreedsForRetriever()
    {
        dogAPIPage.PerformRequestToProducelistOfSubBreedsForRetriever();
    }

    @Test(priority = 4)
    public void performAnApiRequestToProduceRandomImageLinkForSubBreedGolden()
    {
        dogAPIPage.PerformAnApiRequestToProduceRandomImageLinkForSubBreedGolden();
    }
}
