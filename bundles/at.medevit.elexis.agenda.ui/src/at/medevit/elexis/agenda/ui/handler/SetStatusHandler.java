package at.medevit.elexis.agenda.ui.handler;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.slf4j.LoggerFactory;

import ch.elexis.core.common.ElexisEventTopics;
import ch.elexis.core.model.IAppointment;
import ch.elexis.core.model.IPeriod;
import ch.elexis.core.services.holder.ContextServiceHolder;
import ch.elexis.core.services.holder.CoreModelServiceHolder;
import ch.elexis.core.ui.e4.locks.AcquireLockBlockingUi;
import ch.elexis.core.ui.e4.locks.ILockHandler;

public class SetStatusHandler {

	@Inject
	private ESelectionService selectionService;

	@Execute
	public Object execute(@Named("at.medevit.elexis.agenda.ui.command.parameter.statusId") String statusId) {
		Optional<IPeriod> period = getSelectedPeriod();

		period.ifPresent(p -> {
			AcquireLockBlockingUi.aquireAndRun(p, new ILockHandler() {
				@Override
				public void lockFailed() {
					// do nothing
				}

				@Override
				public void lockAcquired() {
					((IAppointment) p).setState(statusId);
					CoreModelServiceHolder.get().save((IAppointment) p);
					ContextServiceHolder.get().postEvent(ElexisEventTopics.EVENT_RELOAD, IAppointment.class);
				}
			});
		});
		return null;
	}

	private Optional<IPeriod> getSelectedPeriod() {
		try {
			ISelection activeSelection = (ISelection) selectionService.getSelection();
			LoggerFactory.getLogger(getClass()).info("Set status [" + activeSelection + "]");
			if (activeSelection instanceof StructuredSelection && !((StructuredSelection) activeSelection).isEmpty()) {
				Object element = ((StructuredSelection) activeSelection).getFirstElement();
				if (element instanceof IPeriod) {
					return Optional.of((IPeriod) element);
				}
			}
		} catch (Exception e) {
			LoggerFactory.getLogger(getClass()).error("Error setting status", e); //$NON-NLS-1$
		}
		return Optional.empty();
	}
}
