package ru.sfilyuta.moneytransfer;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.model.StatusResp;
import ru.sfilyuta.moneytransfer.model.TransferOperationReq;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

import static ru.sfilyuta.moneytransfer.RestApi.createTarget;
import static ru.sfilyuta.moneytransfer.RestApi.createTargetAccount;
import static ru.sfilyuta.moneytransfer.SampleData.sampleAccount;
import static ru.sfilyuta.moneytransfer.SampleData.sampleAccount2;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationRsTest {

    private HttpServer server;
    private WebTarget target;

    private Account srcAccount;
    private Account dstAccount;
    private int transferAmount = 250;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        target = createTarget();

        srcAccount = sampleAccount();
        dstAccount = sampleAccount2();
        createTargetAccount(target, srcAccount);
        createTargetAccount(target, dstAccount);
        doTransfer();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    private void doTransfer() {
        TransferOperationReq request = new TransferOperationReq(
                srcAccount.getNumber(),
                dstAccount.getNumber(),
                transferAmount
        );
        StatusResp statusResp = RestApi.transfer(target, request);
        assertThat(statusResp.getStatus()).isEqualTo(StatusResp.OK.getStatus());
    }

    @Test
    public void amountTransferredCorrectly() {
        Account srcAccountAfterTransfer = RestApi.getAccount(target, srcAccount.getNumber());
        Account dstAccountAfterTransfer = RestApi.getAccount(target, dstAccount.getNumber());
        assertThat(srcAccount.getAmount() - srcAccountAfterTransfer.getAmount()).isEqualTo(transferAmount);
        assertThat(dstAccountAfterTransfer.getAmount() - dstAccount.getAmount()).isEqualTo(transferAmount);
    }
}
