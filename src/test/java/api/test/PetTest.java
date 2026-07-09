package api.test;

import api.endpoints.PetEndPoints;
import factory.LoggerFactory;
import io.restassured.response.Response;
import models.pet.pet.PetStoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PetTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createPet()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");

            List<PetStoreModel.PetModel> petData =
                    JsonUtils.convertJsonListDataModel(
                            petFile,
                            "createPet",
                            PetStoreModel.PetModel.class);

            for (PetStoreModel.PetModel pet : petData)
            {
                Response response = PetEndPoints.createPet(pet);

                response.then().statusCode(200);

                Assert.assertEquals(response.jsonPath().getLong("id"), pet.id);
                Assert.assertEquals(response.jsonPath().getString("name"), pet.name);
                Assert.assertEquals(response.jsonPath().getString("status"), pet.status);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void updatePet()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");

            List<PetStoreModel.PetModel> petData =
                    JsonUtils.convertJsonListDataModel(
                            petFile,
                            "updatePet",
                            PetStoreModel.PetModel.class);

            for (PetStoreModel.PetModel pet : petData)
            {
                Response response = PetEndPoints.updatePet(pet);

                response.then().statusCode(200);

                Assert.assertEquals(response.jsonPath().getLong("id"), pet.id);
                Assert.assertEquals(response.jsonPath().getString("name"), pet.name);
                Assert.assertEquals(response.jsonPath().getString("status"), pet.status);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void getPetById()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");

            List<PetStoreModel.PetModel> petData =
                    JsonUtils.convertJsonListDataModel(
                            petFile,
                            "createPet",
                            PetStoreModel.PetModel.class);

            for (PetStoreModel.PetModel pet : petData)
            {
                Response response = PetEndPoints.getPetById(pet);

                response.then().statusCode(200);

                Assert.assertEquals(response.jsonPath().getLong("id"), pet.id);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void updatePetByStatus()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");

            List<PetStoreModel.PetModel> petData =
                    JsonUtils.convertJsonListDataModel(
                            petFile,
                            "createPet",
                            PetStoreModel.PetModel.class);

            for (PetStoreModel.PetModel pet : petData)
            {
                Response response = PetEndPoints.updatePetByStatus(pet);

                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void findPetByStatus()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");

            List<PetStoreModel.PetModel> petData =
                    JsonUtils.convertJsonListDataModel(
                            petFile,
                            "createPet",
                            PetStoreModel.PetModel.class);

            for (PetStoreModel.PetModel pet : petData)
            {
                Response response = PetEndPoints.findPetByStatus(pet);

                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void deletePet()
    {
        try
        {
            String petFile = FileUtils.getDataFile("pet", "pet", "PetData");

            List<PetStoreModel.PetModel> petData =
                    JsonUtils.convertJsonListDataModel(
                            petFile,
                            "createPet",
                            PetStoreModel.PetModel.class);

            for (PetStoreModel.PetModel pet : petData)
            {
                Response response = PetEndPoints.deletePet(pet);

                response.then().statusCode(200);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}