package Controller.factory;

import db.ConfigFile;

/**
 * Created by jaouhar.mbarek on 27.02.2017.
 */
public class ConfigFactory {

    private String txtPath;

    public ConfigFactory(String txtPath) {
        this.txtPath = txtPath;
    }

    public ConfigFile getConfiguration() {
        return new ConfigFile(txtPath);
    }

}
