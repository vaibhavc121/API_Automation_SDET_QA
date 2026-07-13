package api.test;

import api.endpoints.StoreEndPoints;
import factory.LoggerFactory;
import io.restassured.response.Response;
import models.pet.pet.PetStoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class StoreTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void getInventory()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");
            List<PetStoreModel.StoreModel> storeData = JsonUtils.convertJsonListDataModel(petFile, "store", PetStoreModel.StoreModel.class);

            for (PetStoreModel.StoreModel store : storeData)
            {
                Response response = StoreEndPoints.getInventory();
                System.out.println(response.statusCode());
                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void placeOrder()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");
            List<PetStoreModel.StoreModel> storeData = JsonUtils.convertJsonListDataModel(petFile, "store", PetStoreModel.StoreModel.class);

            for (PetStoreModel.StoreModel store : storeData)
            {
                Response response = StoreEndPoints.placeOrder(store);
                System.out.println(response.statusCode());
                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void getOrder()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");
            List<PetStoreModel.StoreModel> storeData = JsonUtils.convertJsonListDataModel(petFile, "store", PetStoreModel.StoreModel.class);

            for (PetStoreModel.StoreModel store : storeData)
            {
                Response response = StoreEndPoints.placeOrder(store);
                System.out.println(response.statusCode());
                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteOrder()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");
            List<PetStoreModel.StoreModel> storeData = JsonUtils.convertJsonListDataModel(petFile, "store", PetStoreModel.StoreModel.class);

            for (PetStoreModel.StoreModel store : storeData)
            {
                Response response = StoreEndPoints.deleteOrder(store);
                System.out.println(response.statusCode());
                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}