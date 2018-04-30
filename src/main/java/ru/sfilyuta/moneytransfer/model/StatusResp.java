package ru.sfilyuta.moneytransfer.model;

public class StatusResp {
    public static final StatusResp OK = new StatusResp(Status.OK);
    public static final StatusResp ERROR = new StatusResp(Status.ERROR);

    public enum Status {OK, ERROR}

    public StatusResp() {
    }

    private Status status;

    public StatusResp(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
