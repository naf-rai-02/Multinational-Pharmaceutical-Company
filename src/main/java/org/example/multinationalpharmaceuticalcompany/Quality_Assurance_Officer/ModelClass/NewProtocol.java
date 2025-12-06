package org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass;

public class NewProtocol {
    private String protocolName;
    private String protocolDate;
    private String protocolDescription;
    private String protocolType;

    public NewProtocol(String protocolName, String protocolDate, String protocolDescription, String protocolType) {
        this.protocolName = protocolName;
        this.protocolDate = protocolDate;
        this.protocolDescription = protocolDescription;
        this.protocolType = protocolType;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getProtocolDate() {
        return protocolDate;
    }

    public void setProtocolDate(String protocolDate) {
        this.protocolDate = protocolDate;
    }

    public String getProtocolDescription() {
        return protocolDescription;
    }

    public void setProtocolDescription(String protocolDescription) {
        this.protocolDescription = protocolDescription;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }
}
