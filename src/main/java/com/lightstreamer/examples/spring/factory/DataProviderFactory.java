package com.lightstreamer.examples.spring.factory;

import java.io.File;
import java.util.Map;

import com.lightstreamer.interfaces.data.DataProviderException;
import com.lightstreamer.interfaces.data.FailureException;
import com.lightstreamer.interfaces.data.ItemEventListener;
import com.lightstreamer.interfaces.data.SmartDataProvider;
import com.lightstreamer.interfaces.data.SubscriptionException;

public class DataProviderFactory implements SmartDataProvider {

  private SmartDataProvider realDataProvider;

  @Override
  public void init(Map params, File configDir) throws DataProviderException {
    // Retrieve the real Data Adapter implementation from the Spring context
    realDataProvider = SpringContext.getBean((String) params.get("data_adapter"),
        SmartDataProvider.class);

    realDataProvider.init(params, configDir);
  }

  @Override
  public void setListener(ItemEventListener listener) {
    realDataProvider.setListener(listener);
  }

  @Override
  public void unsubscribe(String itemName) throws SubscriptionException, FailureException {
    realDataProvider.unsubscribe(itemName);
  }

  @Override
  public boolean isSnapshotAvailable(String itemName) throws SubscriptionException {
    return realDataProvider.isSnapshotAvailable(itemName);
  }

  @Override
  public void subscribe(String itemName, Object itemHandle, boolean needsIterator)
      throws SubscriptionException, FailureException {
    realDataProvider.subscribe(itemName, itemHandle, needsIterator);
  }

  @Override
  public void subscribe(String itemName, boolean needsIterator)
      throws SubscriptionException, FailureException {
    realDataProvider.subscribe(itemName, needsIterator);
  }

}
