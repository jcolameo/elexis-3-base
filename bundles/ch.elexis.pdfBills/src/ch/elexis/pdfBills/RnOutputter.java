package ch.elexis.pdfBills;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.progress.IProgressService;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.slf4j.LoggerFactory;

import ch.elexis.TarmedRechnung.XMLExporter;
import ch.elexis.TarmedRechnung.XMLExporterUtil;
import ch.elexis.base.ch.arzttarife.xml.exporter.Tarmed45Exporter.EsrType;
import ch.elexis.core.data.activator.CoreHub;
import ch.elexis.core.data.interfaces.IRnOutputter;
import ch.elexis.core.data.util.PlatformHelper;
import ch.elexis.core.data.util.ResultAdapter;
import ch.elexis.core.model.IContact;
import ch.elexis.core.model.ICoverage;
import ch.elexis.core.model.IInvoice;
import ch.elexis.core.model.IPatient;
import ch.elexis.core.model.InvoiceConstants;
import ch.elexis.core.model.InvoiceState;
import ch.elexis.core.model.InvoiceState.REJECTCODE;
import ch.elexis.core.services.holder.ConfigServiceHolder;
import ch.elexis.core.services.holder.CoreModelServiceHolder;
import ch.elexis.core.ui.util.SWTHelper;
import ch.elexis.data.Fall;
import ch.elexis.data.Kontakt;
import ch.elexis.data.Person;
import ch.elexis.data.Rechnung;
import ch.rgw.tools.ExHandler;
import ch.rgw.tools.Result;

public class RnOutputter implements IRnOutputter {
	public static final String PDFDIR = "pdfdir"; //$NON-NLS-1$
	public static final String PLUGIN_ID = "ch.elexis.pdfBills"; //$NON-NLS-1$
	public static final String XMLDIR = "xmldir"; //$NON-NLS-1$
	public static final String CFG_ROOT = "pdf-output/"; //$NON-NLS-1$
	public static final String CFG_MARGINLEFT = "margin.left"; //$NON-NLS-1$
	public static final String CFG_MARGINRIGHT = "margin.right"; //$NON-NLS-1$
	public static final String CFG_MARGINTOP = "margin.top"; //$NON-NLS-1$
	public static final String CFG_MARGINBOTTOM = "margin.bottom"; //$NON-NLS-1$
	public static final String CFG_BESR_MARGIN_VERTICAL = "margin.besr.vertical"; //$NON-NLS-1$
	public static final String CFG_BESR_MARGIN_HORIZONTAL = "margin.besr.horizontal"; //$NON-NLS-1$

	public static final String CFG_ESR_HEADER_1 = CFG_ROOT + "esr.header.line1"; //$NON-NLS-1$
	public static final String CFG_ESR_HEADER_2 = CFG_ROOT + "esr.header.line2"; //$NON-NLS-1$

	public static final String CFG_ESR_COUVERT_LEFT = CFG_ROOT + "esr.couvert.left"; //$NON-NLS-1$

	public static final String CFG_PRINT_DIRECT = CFG_ROOT + "print.direct"; //$NON-NLS-1$

	public static final String CFG_PRINT_PRINTER = CFG_ROOT + "print.printer"; //$NON-NLS-1$
	public static final String CFG_PRINT_TRAY = CFG_ROOT + "print.tray"; //$NON-NLS-1$

	public static final String CFG_ESR_PRINT_PRINTER = CFG_ROOT + "esr.print.printer"; //$NON-NLS-1$
	public static final String CFG_ESR_PRINT_TRAY = CFG_ROOT + "esr.print.tray"; //$NON-NLS-1$

	public static final String CFG_PRINT_COMMAND = CFG_ROOT + "print.command"; //$NON-NLS-1$
	public static final String CFG_PRINT_USE_SCRIPT = CFG_ROOT + "print.usescript"; //$NON-NLS-1$

	public static final String CFG_PRINT_BESR = "print.besr"; //$NON-NLS-1$
	public static final String CFG_PRINT_RF = "print.rf"; //$NON-NLS-1$

	protected static final String CFG_MAIL_CPY = "mail.copy"; //$NON-NLS-1$
	protected static final String CFG_MAIL_MANDANT_ACCOUNT = "mail.mandant.account"; //$NON-NLS-1$

	public static final String CFG_PRINT_USEGUARANTORPOSTAL = CFG_ROOT + "guarantor.postaladdress"; //$NON-NLS-1$

	public static final String CFG_MSGTEXT_TP_M0 = CFG_ROOT + "pdf.txt.tp"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TG_M0 = CFG_ROOT + "pdf.txt.tg"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TP_M1 = CFG_ROOT + "pdf.txt.M1tp"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TP_M2 = CFG_ROOT + "pdf.txt.M2tp"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TP_M3 = CFG_ROOT + "pdf.txt.M3tp"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TG_M1 = CFG_ROOT + "pdf.txt.M1tg"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TG_M2 = CFG_ROOT + "pdf.txt.M2tg"; //$NON-NLS-1$
	public static final String CFG_MSGTEXT_TG_M3 = CFG_ROOT + "pdf.txt.M3tg"; //$NON-NLS-1$

	private Text tXml;
	private Text tPdf;

	private Button bWithEsr;
	private Button bWithRf;

	private boolean modifyInvoiceState;

	@Override
	public String getDescription() {
		return "PDF Output";
	}

	@Override
	public Result<Rechnung> doOutput(final TYPE type, final Collection<Rechnung> rnn, Properties props) {

		if (!props.isEmpty()) {
			initSelectedFromProperties(props);
		} else {
			modifyInvoiceState = true;
		}

		IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
		final Result<Rechnung> res = new Result<Rechnung>();
		final File rsc = new File(PlatformHelper.getBasePath(PLUGIN_ID), "rsc"); //$NON-NLS-1$
		final StringJoiner mailErrors = new StringJoiner("\n- ", "- ", StringUtils.EMPTY); //$NON-NLS-1$ //$NON-NLS-2$
		try {
			progressService.runInUI(PlatformUI.getWorkbench().getProgressService(), new IRunnableWithProgress() {
				public void run(final IProgressMonitor monitor) {
					monitor.beginTask("Exportiere Rechnungen...", rnn.size() * 10);
					int errors = 0;
					for (Rechnung rn : rnn) {
						IInvoice invoice = CoreModelServiceHolder.get().load(rn.getId(), IInvoice.class).orElseThrow(
								() -> new IllegalStateException("Could not load invoice [" + rn.getId() + "]"));

						XMLExporter ex = new XMLExporter();
						ex.setEsrType(EsrType.esr9);
						Document dRn = ex.doExport(rn, null, type, true);
						monitor.worked(1);
						if (invoice.getState() == InvoiceState.DEFECTIVE) {
							errors++;
							continue;
						}
						String fname = OutputterUtil.getXmlOutputDir(CFG_ROOT) + File.separator + invoice.getNumber()
								+ ".xml"; //$NON-NLS-1$
						try {
							FileOutputStream fout = new FileOutputStream(fname);
							OutputStreamWriter cout = new OutputStreamWriter(fout, "UTF-8"); //$NON-NLS-1$
							XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
							xout.output(dRn, cout);
							cout.close();
							fout.close();
							// create an new generator for the bill
							ElexisPDFGenerator epdf = new ElexisPDFGenerator(fname, invoice.getNumber(),
									invoice.getState());
							epdf.printBill(rsc);
							if (modifyInvoiceState) {
								int status_vorher = invoice.getState().numericValue();
								if ((status_vorher == InvoiceState.OPEN.numericValue())
										|| (status_vorher == InvoiceState.DEMAND_NOTE_1.numericValue())
										|| (status_vorher == InvoiceState.DEMAND_NOTE_2.numericValue())
										|| (status_vorher == InvoiceState.DEMAND_NOTE_3.numericValue())) {
									invoice.setState(InvoiceState.fromState(status_vorher + 1));
								}
								invoice.addTrace(InvoiceConstants.OUTPUT, getDescription() + ": " //$NON-NLS-1$
										+ invoice.getState().getLocaleText());
								CoreModelServiceHolder.get().save(invoice);
							}
							if (CoreHub.localCfg.get(CFG_ROOT + CFG_MAIL_CPY, false) && shouldSendCopyMail(rn)) {
								Kontakt guarantor = getGuarantor(rn);
								if (guarantor != null && StringUtils.isNotBlank(guarantor.getMailAddress())) {
									List<File> printed = epdf.getPrintedBill();
									if (!printed.isEmpty()) {
										String resultString = sendAsMail(guarantor, rn, printed);
										if (StringUtils.isNoneBlank(resultString)) {
											mailErrors.add(resultString);
										}
									}
								} else if (guarantor != null) {
									mailErrors.add("Keine mail Addresse für " + guarantor.getLabel(false));
								} else {
									mailErrors.add("Keine Garant für Rechnung " + invoice.getNumber());
								}
							}
						} catch (Exception e1) {
							ExHandler.handle(e1);
							SWTHelper.showError("Fehler beim Rechnungsdruck",
									"Konnte Datei " + fname + " nicht schreiben");
							invoice.reject(REJECTCODE.INTERNAL_ERROR, "write error: " + fname); //$NON-NLS-1$
							CoreModelServiceHolder.get().save(invoice);
							continue;
						}
						monitor.worked(1);
					}
					monitor.done();
					if (errors > 0) {
						SWTHelper.alert("Fehler bei der Übermittlung", Integer.toString(errors)
								+ " Rechnungen waren fehlerhaft. Sie können diese unter Rechnungen mit dem Status fehlerhaft aufsuchen und korrigieren");
					} else {
						SWTHelper.showInfo("Übermittlung beendet", "Es sind keine Fehler aufgetreten");
					}
				}
			}, null);
		} catch (Exception ex) {
			ExHandler.handle(ex);
			if (StringUtils.isNotBlank(ex.getMessage())) {
				res.add(Result.SEVERITY.ERROR, 2, ex.getMessage(), null, true);
			} else if (ex.getCause() != null && StringUtils.isNotBlank(ex.getCause().getMessage())) {
				res.add(Result.SEVERITY.ERROR, 2, ex.getCause().getMessage(), null, true);
			}
			ErrorDialog.openError(null, "Fehler bei der Ausgabe", "Konnte Rechnungsdruck nicht starten",
					ResultAdapter.getResultAsStatus(res));
			return res;
		}
		if (mailErrors.length() > 2) {
			MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), "Fehler beim Mail-Versand",
					null, "Beim Mail-Versand sind folgende Fehler aufgetreten:\n" + mailErrors.toString(),
					MessageDialog.ERROR, 0, new String[] { IDialogConstants.OK_LABEL, "als Text öffnen" }) {

				@Override
				protected void buttonPressed(int buttonId) {
					if (buttonId == 1) {
						try {
							Path tmpFile = Files.createTempFile("error_", "rechnung.txt"); //$NON-NLS-1$ //$NON-NLS-2$
							try (FileWriter fo = new FileWriter(tmpFile.toFile())) {
								fo.write(mailErrors.toString());
							}
							Program.launch(tmpFile.toString());
						} catch (IOException e) {
							LoggerFactory.getLogger(getClass()).error("Error writing tmp file", e); //$NON-NLS-1$
						}
					}
					super.buttonPressed(buttonId);
				}
			};
			dialog.open();
		}
		return res;
	}

	private void initSelectedFromProperties(Properties props) {
		LoggerFactory.getLogger(getClass()).warn("Initializing with properties " + props.toString()); //$NON-NLS-1$
		modifyInvoiceState = true;
		if (props.get(IRnOutputter.PROP_OUTPUT_MODIFY_INVOICESTATE) instanceof String) {
			String value = (String) props.get(IRnOutputter.PROP_OUTPUT_MODIFY_INVOICESTATE);
			modifyInvoiceState = Boolean.parseBoolean(value);
		}
		if (props.get(IRnOutputter.PROP_OUTPUT_WITH_ESR) instanceof String) {
			String value = (String) props.get(IRnOutputter.PROP_OUTPUT_WITH_ESR);
			CoreHub.localCfg.set(CFG_ROOT + CFG_PRINT_BESR, Boolean.parseBoolean(value));
		}
		if (props.get(IRnOutputter.PROP_OUTPUT_WITH_RECLAIM) instanceof String) {
			String value = (String) props.get(IRnOutputter.PROP_OUTPUT_WITH_RECLAIM);
			CoreHub.localCfg.set(CFG_ROOT + CFG_PRINT_RF, Boolean.parseBoolean(value));
		}
		if (props.get(IRnOutputter.PROP_OUTPUT_WITH_MAIL) instanceof String) {
			String value = (String) props.get(IRnOutputter.PROP_OUTPUT_WITH_MAIL);
			CoreHub.localCfg.set(CFG_ROOT + CFG_MAIL_CPY, Boolean.parseBoolean(value));
		}
	}

	private Kontakt getGuarantor(Rechnung rn) {
		ICoverage coverage = CoreModelServiceHolder.get().load(rn.getFall().getId(), ICoverage.class).orElse(null);
		if (coverage != null) {
			IPatient patient = CoreModelServiceHolder.get().load(rn.getFall().getPatient().getId(), IPatient.class)
					.orElse(null);
			if (patient != null) {
				IContact ret = XMLExporterUtil.getGuarantor(XMLExporter.TIERS_PAYANT, patient, coverage);
				if (ret != null) {
					return Kontakt.load(ret.getId());
				}
			}
		}
		return null;
	}

	private boolean shouldSendCopyMail(Rechnung rn) {
		Kontakt guarantor = getGuarantor(rn);
		if (guarantor != null) {
			Fall fall = rn.getFall();
			return !fall.getInvoiceRecipient().equals(guarantor);
		}
		return false;
	}

	private String sendAsMail(Kontakt receiver, Rechnung rechnung, List<File> printed) {
		ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		try {
			String attachmentsString = getAttachmentsString(printed);
			Command sendMailCommand = commandService.getCommand("ch.elexis.core.mail.ui.sendMailNoUi"); //$NON-NLS-1$

			HashMap<String, String> params = new HashMap<String, String>();
			String accountid = ConfigServiceHolder.getGlobal(
					RnOutputter.CFG_ROOT + RnOutputter.CFG_MAIL_MANDANT_ACCOUNT + "/" + rechnung.getMandant().getId(), //$NON-NLS-1$
					null);
			if (accountid != null) {
				params.put("ch.elexis.core.mail.ui.sendMailNoUi.accountid", accountid); //$NON-NLS-1$
			}
			params.put("ch.elexis.core.mail.ui.sendMailNoUi.mandant", rechnung.getMandant().getId()); //$NON-NLS-1$
			params.put("ch.elexis.core.mail.ui.sendMailNoUi.to", receiver.getMailAddress()); //$NON-NLS-1$
			params.put("ch.elexis.core.mail.ui.sendMailNoUi.attachments", attachmentsString); //$NON-NLS-1$
			params.put("ch.elexis.core.mail.ui.sendMailNoUi.subject", "Rechnungskopie vom " + rechnung.getDatumRn()); //$NON-NLS-1$
			params.put("ch.elexis.core.mail.ui.sendMailNoUi.text", //$NON-NLS-1$
					"Anbei finden Sie eine Kopie der Rechnung vom " + rechnung.getDatumRn()
							+ " für Ihre Unterlagen.\n\nBeste Grüsse\n" + rechnung.getMandant().get(Person.TITLE)
							+ StringUtils.SPACE + rechnung.getMandant().getVorname() + StringUtils.SPACE
							+ rechnung.getMandant().getName());

			ParameterizedCommand parametrizedCommmand = ParameterizedCommand.generateCommand(sendMailCommand, params);
			return (String) PlatformUI.getWorkbench().getService(IHandlerService.class)
					.executeCommand(parametrizedCommmand, null);
		} catch (Exception me) {
			throw new RuntimeException("ch.elexis.core.mail.ui.sendMailNoUi not found", me); //$NON-NLS-1$
		}
	}

	private String getAttachmentsString(List<File> attachments) {
		StringBuilder sb = new StringBuilder();
		for (File file : attachments) {
			if (sb.length() > 0) {
				sb.append(":::"); //$NON-NLS-1$
			}
			sb.append(file.getAbsolutePath());
		}
		return sb.toString();
	}

	@Override
	public boolean canStorno(Rechnung rn) {
		return false;
	}

	@Override
	public boolean canBill(Fall fall) {
		return true;
	}

	@Override
	public Object createSettingsControl(Object parent) {
		final Composite compParent = (Composite) parent;
		Composite ret = new Composite(compParent, SWT.NONE);
		ret.setLayoutData(SWTHelper.getFillGridData());
		ret.setLayout(new GridLayout(2, false));
		bWithEsr = new Button(ret, SWT.CHECK);
		bWithEsr.setText("Mit ESR");
		bWithEsr.setSelection(CoreHub.localCfg.get(CFG_ROOT + CFG_PRINT_BESR, true));
		bWithEsr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CoreHub.localCfg.set(CFG_ROOT + CFG_PRINT_BESR, bWithEsr.getSelection());
			}
		});
		bWithEsr.setLayoutData(SWTHelper.getFillGridData(2, true, 1, false));

		bWithRf = new Button(ret, SWT.CHECK);
		bWithRf.setText("Mit Rechnungsformular");
		bWithRf.setSelection(CoreHub.localCfg.get(CFG_ROOT + CFG_PRINT_RF, true));
		bWithRf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CoreHub.localCfg.set(CFG_ROOT + CFG_PRINT_RF, bWithRf.getSelection());
			}
		});
		bWithRf.setLayoutData(SWTHelper.getFillGridData(2, true, 1, false));

		CoreHub.localCfg.set(CFG_ROOT + CFG_MAIL_CPY, false);

		if (OutputterUtil.useGlobalOutputDirs()) {
			Label lXML = new Label(ret, SWT.NONE);
			lXML.setText("XML Verzeichnis: " + CoreHub.globalCfg.get(OutputterUtil.CFG_PRINT_GLOBALXMLDIR, null));
			lXML.setLayoutData(SWTHelper.getFillGridData(2, true, 1, false));
			Label lPDF = new Label(ret, SWT.NONE);
			lPDF.setText("PDF Verzeichnis: " + CoreHub.globalCfg.get(OutputterUtil.CFG_PRINT_GLOBALPDFDIR, null));
			lPDF.setLayoutData(SWTHelper.getFillGridData(2, true, 1, false));
		} else {
			Button bXML = new Button(ret, SWT.PUSH);
			bXML.setText("XML Verzeichnis");
			tXml = new Text(ret, SWT.BORDER | SWT.READ_ONLY);
			tXml.setLayoutData(SWTHelper.getFillGridData(1, true, 1, false));
			Button bPDF = new Button(ret, SWT.PUSH);
			bPDF.setText("PDF Verzeichnis");
			tPdf = new Text(ret, SWT.BORDER | SWT.READ_ONLY);
			tPdf.setLayoutData(SWTHelper.getFillGridData(1, true, 1, false));

			bXML.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog dd = new DirectoryDialog(compParent.getShell());
					String dir = dd.open();
					if (dir != null) {
						tXml.setText(dir);
					}
				}

			});
			bPDF.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog dd = new DirectoryDialog(compParent.getShell());
					String dir = dd.open();
					if (dir != null) {
						tPdf.setText(dir);
					}
				}

			});
			tXml.setText(CoreHub.localCfg.get(CFG_ROOT + XMLDIR, StringUtils.EMPTY));
			tPdf.setText(CoreHub.localCfg.get(CFG_ROOT + PDFDIR, StringUtils.EMPTY));
		}

		return (Control) ret;
	}

	@Override
	public void saveComposite() {
		CoreHub.localCfg.set(CFG_ROOT + CFG_PRINT_BESR, bWithEsr.getSelection());
		CoreHub.localCfg.set(CFG_ROOT + CFG_PRINT_RF, bWithRf.getSelection());
		if (!OutputterUtil.useGlobalOutputDirs()) {
			CoreHub.localCfg.set(CFG_ROOT + XMLDIR, tXml.getText());
			CoreHub.localCfg.set(CFG_ROOT + PDFDIR, tPdf.getText());
		}
		CoreHub.localCfg.flush();
	}

	@Override
	public void openOutput(IInvoice invoice, LocalDateTime timestamp, InvoiceState invoiceState) {
		File esrFile = new File(OutputterUtil.getPdfOutputDir(RnOutputter.CFG_ROOT) + File.separator
				+ invoice.getNumber() + "_esr.pdf");
		File rfFile = new File(
				OutputterUtil.getPdfOutputDir(RnOutputter.CFG_ROOT) + File.separator + invoice.getNumber() + "_rf.pdf");
		if (esrFile.exists()) {
			Program.launch(esrFile.getAbsolutePath());
		} else {
			LoggerFactory.getLogger(getClass()).info("File [" + esrFile.getAbsolutePath() + "] does not exist"); //$NON-NLS-1$
		}
		if (rfFile.exists()) {
			Program.launch(rfFile.getAbsolutePath());
		} else {
			LoggerFactory.getLogger(getClass()).info("File [" + rfFile.getAbsolutePath() + "] does not exist"); //$NON-NLS-1$
		}
	}
}
