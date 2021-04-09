package com.lightstreamer.examples.spring;

import java.io.File;
import java.util.Map;

import com.lightstreamer.interfaces.data.DataProviderException;
import com.lightstreamer.interfaces.data.FailureException;
import com.lightstreamer.interfaces.data.ItemEventListener;
import com.lightstreamer.interfaces.data.SmartDataProvider;
import com.lightstreamer.interfaces.data.SubscriptionException;

public class DataAdapter1 implements SmartDataProvider {

  private ItemEventListener setListener;
  
  private String testString;

  public DataAdapter1() {
  }

  @Override
  public void init(Map params, File configDir) throws DataProviderException {
    System.out.println(testString);
  }

  @Override
  public void setListener(ItemEventListener listener) {
    this.setListener = listener;

  }

  @Override
  public void unsubscribe(String itemName) throws SubscriptionException, FailureException {
  }

  @Override
  public boolean isSnapshotAvailable(String itemName) throws SubscriptionException {
    return false;
  }

  @Override
  public void subscribe(String itemName, Object itemHandle, boolean needsIterator)
      throws SubscriptionException, FailureException {
  }

  @Override
  public void subscribe(String itemName, boolean needsIterator)
      throws SubscriptionException, FailureException {
  }

  public void setTestString(String testString) {
    this.testString = testString;
  }

}
