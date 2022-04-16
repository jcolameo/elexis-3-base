/*******************************************************************************
 * Copyright (c) 2010 by Niklaus Giger
 * based on importer.java by G. Weirich
 * Adapted from Viollier to Bioanalytica by Daniel Lutz <danlutz@watz.ch>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package ch.elexis.laborimport.analytica;


import org.eclipse.osgi.util.NLS;
public class Messages extends NLS {
  public static final String BUNDLE_NAME = "ch.elexis.laborimport.analytica.messages";

  public static String Importer_automatisch = ch.elexis.core.l10n.Messages.Importer_automatisch;
  public static String Importer_batch_label = ch.elexis.core.l10n.Messages.Importer_batch_label;
  public static String Importer_batchFehler_error = ch.elexis.core.l10n.Messages.Importer_batchFehler_error;
  public static String Importer_cancelled = ch.elexis.core.l10n.Messages.Importer_cancelled;
  public static String Importer_error_archivieren = ch.elexis.core.l10n.Messages.Importer_error_archivieren;
  public static String Importer_error_import = ch.elexis.core.l10n.Messages.Importer_error_import;
  public static String Importer_error_moveToArchive = ch.elexis.core.l10n.Messages.Importer_error_moveToArchive;
  public static String Importer_ftp_label = ch.elexis.core.l10n.Messages.Importer_ftp_label;
  public static String Importer_import_header = ch.elexis.core.l10n.Messages.Importer_import_header;
  public static String Importer_import_message = ch.elexis.core.l10n.Messages.Importer_import_message;
  public static String Importer_lab = ch.elexis.core.l10n.Messages.Importer_lab;
  public static String Importer_label_importDirect = ch.elexis.core.l10n.Messages.Importer_label_importDirect;
  public static String Importer_label_importFile = ch.elexis.core.l10n.Messages.Importer_label_importFile;
  public static String Importer_leereBatchdatei_error = ch.elexis.core.l10n.Messages.Importer_leereBatchdatei_error;
  public static String Importer_ok = ch.elexis.core.l10n.Messages.Importer_ok;
  public static String Importer_question_allreadyImported = ch.elexis.core.l10n.Messages.Importer_question_allreadyImported;
  public static String Importer_question_allreadyImported_continue = ch.elexis.core.l10n.Messages.Importer_question_allreadyImported_continue;
  public static String Importer_semaphore_error = ch.elexis.core.l10n.Messages.Importer_semaphore_error;
  public static String Importer_title_description = ch.elexis.core.l10n.Messages.Importer_title_description;
  public static String ImporterPage_allFiles = ch.elexis.core.l10n.Messages.ImporterPage_allFiles;
  public static String ImporterPage_browse = ch.elexis.core.l10n.Messages.ImporterPage_browse;
  public static String ImporterPage_file = ch.elexis.core.l10n.Messages.ImporterPage_file;
  public static String PreferencePage_batchdatei_label = ch.elexis.core.l10n.Messages.PreferencePage_batchdatei_label;
  public static String PreferencePage_batchscript_label = ch.elexis.core.l10n.Messages.PreferencePage_batchscript_label;
  public static String PreferencePage_direktimport_label = ch.elexis.core.l10n.Messages.PreferencePage_direktimport_label;
  public static String PreferencePage_ftpserver_label = ch.elexis.core.l10n.Messages.PreferencePage_ftpserver_label;
  public static String PreferencePage_label_download = ch.elexis.core.l10n.Messages.PreferencePage_label_download;
  public static String PreferencePage_label_host = ch.elexis.core.l10n.Messages.PreferencePage_label_host;
  public static String PreferencePage_label_ovpn = ch.elexis.core.l10n.Messages.PreferencePage_label_ovpn;
  public static String PreferencePage_label_password = ch.elexis.core.l10n.Messages.PreferencePage_label_password;
  public static String PreferencePage_label_user = ch.elexis.core.l10n.Messages.PreferencePage_label_user;
  public static String PreferencePage_title_description = ch.elexis.core.l10n.Messages.PreferencePage_title_description;
  static { // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}

