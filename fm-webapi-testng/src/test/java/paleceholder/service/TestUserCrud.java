package paleceholder.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.example.models.placeholder.user.UserDto;
import org.example.services.Services;
import org.example.testcases.groups.BaseGroups;
import org.example.testcases.testdata.TestData;
import org.testng.annotations.Test;
import paleceholder.BaseTestNgTests;


public class TestUserCrud extends BaseTestNgTests {

    @Test(testName = "TC-01",
          description = "REST: POST: Verify ability to create new user",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testCreatingNewUser() {
        UserDto userDto = TestData.userTestData().randomUser();
        UserDto createdUserResponse = Services.placeholderApi().user().create(userDto);

        // Verification
        Assertions.assertThat(createdUserResponse)
            .usingRecursiveComparison()
            .ignoringAllOverriddenEquals()
            .ignoringFields("id")
            .isEqualTo(userDto);
    }

    @Test(testName = "TC-02",
        description = "REST: PUT: Verify ability to update user",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testUpdateUser() {
        UserDto userDto = TestData.userTestData().randomUser();
        UserDto createdUserResponse = Services.placeholderApi().user().update(9, userDto);

        // Verification
        Assertions.assertThat(createdUserResponse)
            .usingRecursiveComparison()
            .ignoringAllOverriddenEquals()
            .ignoringFields("id")
            .isEqualTo(userDto);
    }

    @Test(testName = "TC-03",
        description = "REST: GET: Verify ability to retrieve user by Id",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testRetrieveUserById() {
        String userId = "10";
        UserDto user = Services.placeholderApi().user().getById(userId);

        // Verification
        Assertions.assertThat(user)
            .usingRecursiveComparison()
            .comparingOnlyFields("name", "username")
            .isEqualTo(new UserDto()
                .setName("Clementina DuBuque")
                .setUsername("Moriah.Stanton"));
    }

    @Test(testName = "TC-04",
        description = "REST: GET: Verify ability to retrieve users list",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testRetrieveAllUsers() {
        List<UserDto> users = Services.placeholderApi().user().getAll();

        // Verification
        Assertions.assertThat(users)
            .hasSize(10)
            .extracting("name")
            .contains("Clementina DuBuque", "Glenna Reichert", "Nicholas Runolfsdottir V");
    }


}
