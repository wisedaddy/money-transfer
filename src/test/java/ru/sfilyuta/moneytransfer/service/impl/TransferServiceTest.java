package ru.sfilyuta.moneytransfer.service.impl;

import ru.sfilyuta.moneytransfer.model.Account;
import ru.sfilyuta.moneytransfer.service.TransferService;
import org.junit.Before;
import org.junit.Test;

import static ru.sfilyuta.moneytransfer.SampleData.sampleAccount;
import static ru.sfilyuta.moneytransfer.SampleData.sampleAccount2;

public class TransferServiceTest {

    private Account src;
    private Account dst;
    int transferAmount = 250;
    private TransferService transferService;

    @Before
    public void setUp() throws Exception {
        src = sampleAccount();
        dst = sampleAccount2();
        transferService = new TransferServiceImpl();
    }

    @Test
    public void testTransfer() {
        transferService.transfer(src, dst, transferAmount);
    }
}