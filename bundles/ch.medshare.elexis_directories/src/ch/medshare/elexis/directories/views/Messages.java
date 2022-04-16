/**********************************************************************
 * Copyright (c) 2005 IBM Corporation and others. All rights reserved.   This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM - Initial API and implementation
 **********************************************************************/
package ch.medshare.elexis.directories.views;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "ch.medshare.elexis.directories.views.messages"; //$NON-NLS-1$
	public static String WeisseSeitenSearchForm_btn_Suchen = ch.elexis.core.l10n.Messages.WeisseSeitenSearchForm_btn_Suchen;
	public static String WeisseSeitenSearchForm_label_Ort = ch.elexis.core.l10n.Messages.WeisseSeitenSearchForm_label_Ort;
	public static String WeisseSeitenSearchForm_label_werWasWo = ch.elexis.core.l10n.Messages.WeisseSeitenSearchForm_label_werWasWo;
	public static String WeisseSeitenSearchView_header_Adresse = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_header_Adresse;
	public static String WeisseSeitenSearchView_header_Name = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_header_Name;
	public static String WeisseSeitenSearchView_header_Ort = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_header_Ort;
	public static String WeisseSeitenSearchView_header_Plz = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_header_Plz;
	public static String WeisseSeitenSearchView_header_Tel = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_header_Tel;
	public static String WeisseSeitenSearchView_header_Zusatz = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_header_Zusatz;
	public static String WeisseSeitenSearchView_popup_newKontakt = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_popup_newKontakt;
	public static String WeisseSeitenSearchView_popup_newPatient = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_popup_newPatient;
	public static String WeisseSeitenSearchView_tooltip_newKontakt = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_tooltip_newKontakt;
	public static String WeisseSeitenSearchView_tooltip_newPatient = ch.elexis.core.l10n.Messages.WeisseSeitenSearchView_tooltip_newPatient;
	static { // load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	private Messages(){}
}
