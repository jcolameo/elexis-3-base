/**********************************************************************
 * Copyright (c) 2005 IBM Corporation and others. All rights reserved.   This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM - Initial API and implementation
 **********************************************************************/
package ch.elexis.base.ch.labortarif_2009;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = "ch.elexis.base.ch.labortarif_2009.messages"; //$NON-NLS-1$
    public static String DetailDisplay_chapter = ch.elexis.core.l10n.Messages.DetailDisplay_chapter;
    public static String DetailDisplay_code = ch.elexis.core.l10n.Messages.DetailDisplay_code;
    public static String DetailDisplay_fachbereich = ch.elexis.core.l10n.Messages.DetailDisplay_fachbereich;
    public static String DetailDisplay_limitation = ch.elexis.core.l10n.Messages.DetailDisplay_limitation;
    public static String DetailDisplay_name = ch.elexis.core.l10n.Messages.DetailDisplay_name;
    public static String DetailDisplay_taxpoints = ch.elexis.core.l10n.Messages.DetailDisplay_taxpoints;
    public static String Importer_importEAL = ch.elexis.core.l10n.Messages.Importer_importEAL;
    public static String Importer_selectFile = ch.elexis.core.l10n.Messages.Importer_selectFile;
    public static String Labor2009Selector_code = ch.elexis.core.l10n.Messages.Labor2009Selector_code;
    public static String Labor2009Selector_text = ch.elexis.core.l10n.Messages.Labor2009Selector_text;
    public static String Preferences_automaticAdditionsGroup = ch.elexis.core.l10n.Messages.Preferences_automaticAdditionsGroup;
    public static String Preferences_automaticAdditionsToLabel = ch.elexis.core.l10n.Messages.Preferences_automaticAdditionsToLabel;
    public static String Preferences_automaticallyCalculatioAdditions = ch.elexis.core.l10n.Messages.Preferences_automaticallyCalculatioAdditions;
    public static String Preferences_pleaseEnterMultiplier = ch.elexis.core.l10n.Messages.Preferences_pleaseEnterMultiplier;
    public static String Preferences_specialities = ch.elexis.core.l10n.Messages.Preferences_specialities;

    static { // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }
}
