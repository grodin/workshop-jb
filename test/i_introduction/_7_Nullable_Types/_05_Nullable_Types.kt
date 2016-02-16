package i_introduction._7_Nullable_Types

import org.junit.Test
import junit.framework.Assert

class _05_Nullable_Types {
    fun testSendMessageToClient(
            client: Client?,
            message: String?,
            email: String? = null,
            shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        sendMessageToClient(client, message, object : Mailer {
            public override fun sendMessage(email: String, message: String) {
                invoked = true
                Assert.assertEquals("The message is not as expected:",
                        message, message)
                Assert.assertEquals("The email is not as expected:",
                        email, email)
            }
        })
        Assert.assertEquals("The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked",
                shouldBeInvoked, invoked)
    }

    @Test fun everythingIsOk() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")),
                "Hi Bob! We have an awesome proposition for you...",
                "bob@gmail.com",
                true)
    }

    @Test fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }
}
