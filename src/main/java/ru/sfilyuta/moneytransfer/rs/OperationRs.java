package ru.sfilyuta.moneytransfer.rs;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.model.StatusResp;
import ru.sfilyuta.moneytransfer.model.TransferOperationReq;
import ru.sfilyuta.moneytransfer.service.AccountService;
import ru.sfilyuta.moneytransfer.service.TransferService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.google.common.base.Preconditions.checkNotNull;

@Path("/operation")
public class OperationRs {

    @Inject
    private TransferService transferService;

    @Inject
    private AccountService accountService;

    @POST
    @Path("/transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResp transfer(TransferOperationReq request) {
        Integer src = request.getSrc();
        Integer dst = request.getDst();
        Integer amount = request.getAmount();
        checkNotNull(src);
        checkNotNull(dst);
        checkNotNull(amount);
        Account srcAccount = accountService.get(src);
        Account dstAccount = accountService.get(dst);
        if (transferService.transfer(srcAccount, dstAccount, amount)) {
            return StatusResp.OK;
        } else {
            return StatusResp.ERROR;
        }
    }

}
