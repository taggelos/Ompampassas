package gr.uoa.di.services;

import gr.uoa.di.entities.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserServiceImplTest {
    User test;

    @Before
    public void setUp() throws Exception {
        test = new User();
        test.setId(Integer.parseInt("testId"));
        test.setEmail("testEmail");
        test.setPassword("testPass");
        test.setRole("ROLE_USER");
        test.setSurname("testSur");
        System.out.println("BEFORE");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AFTER");
    }

    @Test
    public void findByUsername() throws Exception {
        try {
            //assertEquals(test,);
            Assert.fail("Should have thrown an exception");
        } catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
        }
    }

}