package de.dytanic.cloudnet.ext.storage.ftp.storage;


import de.dytanic.cloudnet.ext.storage.ftp.client.FTPCredentials;
import de.dytanic.cloudnet.ext.storage.ftp.client.FTPType;
import de.dytanic.cloudnet.template.ITemplateStorage;

public abstract class AbstractFTPStorage implements ITemplateStorage {

    private final String name;
    protected FTPCredentials credentials;
    protected FTPType ftpType;
    protected String baseDirectory;

    AbstractFTPStorage(String name, FTPCredentials credentials, FTPType ftpType) {
        this.name = name;
        this.credentials = credentials;
        this.ftpType = ftpType;

        String baseDirectory = credentials.getBaseDirectory();

        this.baseDirectory = baseDirectory.endsWith("/") ? baseDirectory.substring(0, baseDirectory.length() - 1) : baseDirectory;
    }

    public abstract boolean connect();

    public abstract boolean isAvailable();

    public abstract void completeDataTransfer();

    @Override
    public String getName() {
        return name;
    }

    public FTPCredentials getCredentials() {
        return credentials;
    }

    public FTPType getFtpType() {
        return ftpType;
    }

    public String getBaseDirectory() {
        return baseDirectory;
    }

}
