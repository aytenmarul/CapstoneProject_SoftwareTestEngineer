package stepDefinitions.backend_Api.address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.ApiUtilities;

import java.util.List;
import java.util.Random;

import static stepDefinitions.backend_Api.address.US010_StepDefs.response;
import static stepDefinitions.backend_Api.address.US010_StepDefs.token;

public class US011api_StepDefs {
//    @Given("user connects to the {string} api")
//    public void userConnectsToTheApi(String arg0) {
//    }
//
//    @And("the user updates the address")
//    public void theUserUpdatesTheAddress() {
//    }
//
//    @Then("the user verifies that the status code is {int}")
//    public void theUserVerifiesThatTheStatusCodeIs(int arg0) {
//    }
//}


    Integer id;
    Random random = new Random();

    public static List<Integer> addressIds;

    @And("the user updates the address")
    public void theUserUpdatesTheAddress() {
//        addressIds= ApiUtilities.Address.getAddress(USER.valueOf(token));
        addressIds= ApiUtilities.Address.getAddress(token);
        id=addressIds.get(random.nextInt(addressIds.size()));
        ApiUtilities.Address.updateAddress(id, "Massachusset",
                "Mississauga", true, false,
                "13579", "On", "Office", false, token);
    }

    @Then("user vefies address is updated")
    public void userVefiesAddressIsUpdated() {

        response.jsonPath().getList("address");
    }

    @Then("User verifes updating message")
    public void userVerifesUpdatingMessage() {
        System.out.println("descr="+response.jsonPath().getString("descr"));
    }
}
