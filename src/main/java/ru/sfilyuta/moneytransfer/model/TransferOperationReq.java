package ru.sfilyuta.moneytransfer.model;

public class TransferOperationReq {
    private Integer src;
    private Integer dst;
    private Integer amount;

    public TransferOperationReq() {
    }

    public TransferOperationReq(Integer src, Integer dst, Integer amount) {
        this.src = src;
        this.dst = dst;
        this.amount = amount;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public Integer getDst() {
        return dst;
    }

    public void setDst(Integer dst) {
        this.dst = dst;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
