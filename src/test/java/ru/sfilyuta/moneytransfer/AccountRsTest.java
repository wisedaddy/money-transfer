package ru.sfilyuta.moneytransfer;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.model.StatusResp;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

import static ru.sfilyuta.moneytransfer.RestApi.*;
import static ru.sfilyuta.moneytransfer.SampleData.sampleAccount;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountRsTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        target = createTarget();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    @Test
    public void statusOkWhenCreatingNewAccount() {
        StatusResp statusResp = createTargetAccount(target, sampleAccount());
        assertThat(statusResp.getStatus())
                .isEqualTo(StatusResp.Status.OK);
    }

    @Test
    public void getsAccountCorrectly() {
        Account sampleAccount = sampleAccount();
        createTargetAccount(target, sampleAccount);
        Account created = getAccount(target, sampleAccount.getNumber());
        assertThat(created)
                .isEqualToComparingFieldByField(sampleAccount);
    }

}
