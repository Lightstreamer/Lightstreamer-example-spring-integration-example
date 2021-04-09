package com.lightstreamer.examples.spring;

import java.io.File;
import java.util.Map;

import com.lightstreamer.interfaces.metadata.ItemsException;
import com.lightstreamer.interfaces.metadata.MetadataProviderAdapter;
import com.lightstreamer.interfaces.metadata.MetadataProviderException;
import com.lightstreamer.interfaces.metadata.SchemaException;

public class MetadataAdapter extends MetadataProviderAdapter {

  private String testString;

  @Override
  public void init(Map params, File configDir) throws MetadataProviderException {
    super.init(params, configDir);
    System.out.println(testString);
  }

  @Override
  public String[] getItems(String user, String sessionID, String group) throws ItemsException {
    return null;
  }

  @Override
  public String[] getSchema(String user, String sessionID, String group, String schema)
      throws ItemsException, SchemaException {
    return null;
  }

  public void setTestString(String testString) {
    this.testString = testString;
  }

}
