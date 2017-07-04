package gr.uoa.di.services;

import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.ParentRegisterForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistence.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private ParentRegisterForm form;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
        form = new ParentRegisterForm();
        form.setName("Name");
        form.setPhone("Phone");
        form.setSurname("Surname");
        form.setEmail("parent@unit.test");
        form.setPassword("111111");
        form.setPasswordConfirmation("111111");

        userService.createParent(form);
    }

    @Test
    public void createParent() throws Exception {
        User user = userService.findByUsername(form.getEmail());
        Assert.assertNotEquals(user, null);
        Assert.assertEquals(user.getEmail(), form.getEmail());
        Assert.assertEquals(user.getProviderMetadataById(), null);
        //Assert.assertEquals(user.getPassword(), form.getPassword());

        ParentMetadata metadata = user.getParentMetadataById();
        Assert.assertNotEquals(metadata, null);
        Assert.assertEquals(metadata.getFirstName(), form.getName());
        Assert.assertEquals(metadata.getLastName(), form.getSurname());
        Assert.assertEquals(metadata.getPhone(), form.getPhone());
    }

}
