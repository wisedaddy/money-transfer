package ru.sfilyuta.moneytransfer;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.model.StatusResp;
import ru.sfilyuta.moneytransfer.model.TransferOperationReq;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestApi {

    public static final String ACCOUNT_URL = "account";
    public static final String OPERATION_TRANSFER_URL = "operation/transfer";

    public static WebTarget createTarget() {
        Client c = ClientBuilder.newClient();
        return c.target(Main.BASE_URI);
    }

    public static StatusResp createTargetAccount(WebTarget target, Account account) {
        return target.path(ACCOUNT_URL + "/create")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(account), StatusResp.class);
    }

    public static StatusResp transfer(WebTarget target,
                                                 TransferOperationReq request) {
        return target.path(OPERATION_TRANSFER_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(request), StatusResp.class);
    }

    public static Account getAccount(WebTarget target, int number) {
        return target.path(ACCOUNT_URL + "/get/{account}")
                .resolveTemplate("account", number)
                .request(MediaType.APPLICATION_JSON)
                .get(Account.class);
    }
}
