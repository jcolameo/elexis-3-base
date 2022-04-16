/*******************************************************************************
 * Copyright (c) 2009, G. Weirich and Elexis
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    G. Weirich - initial implementation
 *    
 *******************************************************************************/

package ch.elexis.agenda.ui.week;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "ch.elexis.agenda.ui.week.messages"; //$NON-NLS-1$
	public static String AgendaWeek_selectWeek = ch.elexis.core.l10n.Messages.AgendaWeek_selectWeek;
	public static String AgendaWeek_setZoomFactor = ch.elexis.core.l10n.Messages.AgendaWeek_setZoomFactor;
	public static String AgendaWeek_showCalendarToSelect = ch.elexis.core.l10n.Messages.AgendaWeek_showCalendarToSelect;
	public static String AgendaWeek_showNextWeek = ch.elexis.core.l10n.Messages.AgendaWeek_showNextWeek;
	public static String AgendaWeek_showPreviousWeek = ch.elexis.core.l10n.Messages.AgendaWeek_showPreviousWeek;
	public static String AgendaWeek_weekBackward = ch.elexis.core.l10n.Messages.AgendaWeek_weekBackward;
	public static String AgendaWeek_weekForward = ch.elexis.core.l10n.Messages.AgendaWeek_weekForward;
	public static String AgendaWeek_zoom = ch.elexis.core.l10n.Messages.AgendaWeek_zoom;
	public static String ColumnHeader_configureDisplay = ch.elexis.core.l10n.Messages.ColumnHeader_configureDisplay;
	public static String ColumnHeader_displayWeekdays = ch.elexis.core.l10n.Messages.ColumnHeader_displayWeekdays;
	public static String ColumnHeader_pleaseSelectWeekdays = ch.elexis.core.l10n.Messages.ColumnHeader_pleaseSelectWeekdays;
	public static String ColumnHeader_selectDaysToDisplay = ch.elexis.core.l10n.Messages.ColumnHeader_selectDaysToDisplay;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	private Messages(){}
}
