package ru.sfilyuta.moneytransfer.rs;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.model.StatusResp;
import ru.sfilyuta.moneytransfer.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountRs {

    @Inject
    private AccountService accountService;

    @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResp createAccount(Account account) {
        if (accountService.create(account)) {
            return StatusResp.OK;
        } else {
            return StatusResp.ERROR;
        }
    }

    @GET
    @Path("/get/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("number") Integer accountNumber) {
        return accountService.get(accountNumber);
    }

}
