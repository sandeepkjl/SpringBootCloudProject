package com.example.sandeep.transferservice.model;

public class TransferResponse {
    private String fromAccountId;
    private String toAccountId;
    private String amount;
    private String transferStatus;

    public TransferResponse() {
    }

    public TransferResponse(String fromAccountId, String toAccountId, String amount, String transferStatus) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.transferStatus = transferStatus;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", amount='" + amount + '\'' +
                ", transferStatus='" + transferStatus + '\'' +
                '}';
    }
}
