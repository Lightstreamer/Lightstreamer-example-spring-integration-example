package com.lightstreamer.examples.spring.factory;

import java.io.File;
import java.util.Map;

import com.lightstreamer.interfaces.metadata.AccessException;
import com.lightstreamer.interfaces.metadata.CreditsException;
import com.lightstreamer.interfaces.metadata.CustomizableItemEvent;
import com.lightstreamer.interfaces.metadata.ItemEvent;
import com.lightstreamer.interfaces.metadata.ItemsException;
import com.lightstreamer.interfaces.metadata.MetadataControlListener;
import com.lightstreamer.interfaces.metadata.MetadataProvider;
import com.lightstreamer.interfaces.metadata.MetadataProviderAdapter;
import com.lightstreamer.interfaces.metadata.MetadataProviderException;
import com.lightstreamer.interfaces.metadata.Mode;
import com.lightstreamer.interfaces.metadata.MpnDeviceInfo;
import com.lightstreamer.interfaces.metadata.MpnSubscriptionInfo;
import com.lightstreamer.interfaces.metadata.NotificationException;
import com.lightstreamer.interfaces.metadata.SchemaException;
import com.lightstreamer.interfaces.metadata.TableInfo;

public class MetadataProviderFactory extends MetadataProviderAdapter {

  private MetadataProvider realMetadataAdapter;

  @Override
  public void init(Map params, File configDir) throws MetadataProviderException {
    // Retrieve the real Metadata Adapter implementation from the Spring context
    realMetadataAdapter = SpringContext.getBean((String) params.get("metadata_adapter"),
        MetadataProviderAdapter.class);
    realMetadataAdapter.init(params, configDir);
  }

  public void setListener(MetadataControlListener listener) {
    realMetadataAdapter.setListener(listener);
  }

  public void notifyUser(String user, String password, Map httpHeaders)
      throws AccessException, CreditsException {
    realMetadataAdapter.notifyUser(user, password, httpHeaders);
  }

  public void notifyUser(String user, String password, Map httpHeaders, String clientPrincipal)
      throws AccessException, CreditsException {
    realMetadataAdapter.notifyUser(user, password, httpHeaders, clientPrincipal);
  }

  public String[] getItems(String user, String sessionID, String group) throws ItemsException {
    return realMetadataAdapter.getItems(user, sessionID, group);
  }

  public String[] getSchema(String user, String sessionID, String group, String schema)
      throws ItemsException, SchemaException {
    return realMetadataAdapter.getSchema(user, sessionID, group, schema);
  }

  public double getAllowedMaxBandwidth(String user) {
    return realMetadataAdapter.getAllowedMaxBandwidth(user);
  }

  public double getAllowedMaxItemFrequency(String user, String item) {
    return realMetadataAdapter.getAllowedMaxItemFrequency(user, item);
  }

  public int getAllowedBufferSize(String user, String item) {
    return realMetadataAdapter.getAllowedBufferSize(user, item);
  }

  public boolean isModeAllowed(String user, String item, Mode mode) {
    return realMetadataAdapter.isModeAllowed(user, item, mode);
  }

  public boolean modeMayBeAllowed(String item, Mode mode) {
    return realMetadataAdapter.modeMayBeAllowed(item, mode);
  }

  public boolean isSelectorAllowed(String user, String item, String selector) {
    return realMetadataAdapter.isSelectorAllowed(user, item, selector);
  }

  public boolean isSelected(String user, String item, String selector, ItemEvent event) {
    return realMetadataAdapter.isSelected(user, item, selector, event);
  }

  public boolean enableUpdateCustomization(String user, String item) {
    return realMetadataAdapter.enableUpdateCustomization(user, item);
  }

  public void customizeUpdate(String user, String item, CustomizableItemEvent event) {
    realMetadataAdapter.customizeUpdate(user, item, event);
  }

  public double getMinSourceFrequency(String item) {
    return realMetadataAdapter.getMinSourceFrequency(item);
  }

  public int getDistinctSnapshotLength(String item) {
    return realMetadataAdapter.getDistinctSnapshotLength(item);
  }

  public void notifyUserMessage(String user, String sessionID, String message)
      throws CreditsException, NotificationException {
    realMetadataAdapter.notifyUserMessage(user, sessionID, message);
  }

  public void notifyNewSession(String user, String sessionID, Map clientContext)
      throws CreditsException, NotificationException {
    realMetadataAdapter.notifyNewSession(user, sessionID, clientContext);
  }

  public int getSessionTimeToLive(String user, String session) {
    return realMetadataAdapter.getSessionTimeToLive(user, session);
  }

  public void notifySessionClose(String sessionID) throws NotificationException {
    realMetadataAdapter.notifySessionClose(sessionID);
  }

  public boolean wantsTablesNotification(String user) {
    return realMetadataAdapter.wantsTablesNotification(user);
  }

  public void notifyNewTables(String user, String sessionID, TableInfo[] tables)
      throws CreditsException, NotificationException {
    realMetadataAdapter.notifyNewTables(user, sessionID, tables);
  }

  public void notifyTablesClose(String sessionID, TableInfo[] tables) throws NotificationException {
    realMetadataAdapter.notifyTablesClose(sessionID, tables);
  }

  public void notifyMpnDeviceAccess(String user, String sessionID, MpnDeviceInfo device)
      throws CreditsException, NotificationException {
    realMetadataAdapter.notifyMpnDeviceAccess(user, sessionID, device);
  }

  public void notifyMpnSubscriptionActivation(String user, String sessionID, TableInfo table,
      MpnSubscriptionInfo mpnSubscription) throws CreditsException, NotificationException {
    realMetadataAdapter.notifyMpnSubscriptionActivation(user, sessionID, table, mpnSubscription);
  }

  public void notifyMpnDeviceTokenChange(String user, String sessionID, MpnDeviceInfo device,
      String newDeviceToken) throws CreditsException, NotificationException {
    realMetadataAdapter.notifyMpnDeviceTokenChange(user, sessionID, device, newDeviceToken);
  }

}
