package ru.sfilyuta.moneytransfer;

import ru.sfilyuta.moneytransfer.service.AccountService;
import ru.sfilyuta.moneytransfer.service.TransferService;
import ru.sfilyuta.moneytransfer.service.impl.AccountServiceImpl;
import ru.sfilyuta.moneytransfer.service.impl.TransferServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class ServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(AccountServiceImpl.class).to(AccountService.class).in(Singleton.class);
        bind(TransferServiceImpl.class).to(TransferService.class).in(Singleton.class);
    }
}
