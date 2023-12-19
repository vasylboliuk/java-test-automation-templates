package paleceholder.service;

import static org.example.services.Services.placeholderApi;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.example.generators.Generator;
import org.example.models.placeholder.comment.CommentDto;
import org.example.testcases.groups.BaseGroups;
import org.testng.annotations.Test;
import paleceholder.BaseTestNgTests;

public class TestCommentCrud extends BaseTestNgTests {

    @Test(testName = "TC-10",
        description = "REST: POST: Verify ability to create new Comment",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testCreatingNewComment() {
        CommentDto commentDto = new CommentDto()
            .setPostId(Generator.randomNumber())
            .setName("name_" + Generator.randomString())
            .setEmail(Generator.randomEmail())
            .setBody(Generator.randomString(100));
        CommentDto createdCommentResponse = placeholderApi().comment().create(commentDto);

        // Verification
        Assertions.assertThat(createdCommentResponse)
            .usingRecursiveComparison()
            .ignoringAllOverriddenEquals()
            .ignoringFields("id")
            .isEqualTo(commentDto);
    }

    @Test(testName = "TC-11",
        description = "REST: PUT: Verify ability to update Comment",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testUpdateComment() {
        int commentId = 1;
        CommentDto commentDto = new CommentDto()
            .setPostId(commentId)
            .setName("UpdateName_" + Generator.randomString())
            .setEmail("UpdatedEmail_" + Generator.randomEmail())
            .setBody(Generator.randomString(100));
        CommentDto updateResponse = placeholderApi().comment().update(commentId, commentDto);

        // Verification
        Assertions.assertThat(updateResponse)
            .usingRecursiveComparison()
            .ignoringAllOverriddenEquals()
            .ignoringFields("id")
            .isEqualTo(commentDto);
    }

    @Test(testName = "TC-12",
        description = "REST: GET: Verify ability to retrieve user by Id",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testRetrieveCommentById() {
        int commentId = 5;
        CommentDto user = placeholderApi().comment().getById(commentId);

        // Verification
        Assertions.assertThat(user)
            .usingRecursiveComparison()
            .comparingOnlyFields("name", "email")
            .isEqualTo(new CommentDto()
                .setName("vero eaque aliquid doloribus et culpa")
                .setEmail("Hayden@althea.biz"));
    }

    @Test(testName = "TC-13",
        description = "REST: GET: Verify ability to retrieve Comments list",
        groups = { BaseGroups.BAT, BaseGroups.REG, BaseGroups.API, BaseGroups.COMP })
    public void testRetrieveAllComments() {
        List<CommentDto> users = placeholderApi().comment().getAll();

        // Verification
        Assertions.assertThat(users)
            .hasSizeGreaterThan(300)
            .extracting("name")
            .contains(
                "id labore ex et quam laborum",
                "quo vero reiciendis velit similique earum",
                "odio adipisci rerum aut animi"
            );
    }


}
