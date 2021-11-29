package ch.elexis.base.ch.arzttarife.nutrition.model;

import java.time.LocalDate;

import ch.elexis.base.ch.arzttarife.model.service.CoreModelServiceHolder;
import ch.elexis.base.ch.arzttarife.nutrition.INutritionLeistung;
import ch.elexis.core.jpa.model.adapter.AbstractIdDeleteModelAdapter;
import ch.elexis.core.model.IBillableOptifier;
import ch.elexis.core.model.IBillableVerifier;
import ch.elexis.core.model.IBilled;
import ch.elexis.core.model.IXid;
import ch.elexis.core.model.Identifiable;
import ch.elexis.core.model.billable.AbstractOptifier;
import ch.elexis.core.model.billable.DefaultVerifier;
import ch.elexis.core.services.holder.ContextServiceHolder;
import ch.elexis.core.services.holder.XidServiceHolder;

public class NutritionLeistung
		extends AbstractIdDeleteModelAdapter<ch.elexis.core.jpa.entities.NutritionLeistung>
		implements Identifiable, INutritionLeistung {
	
	public static final String STS_CLASS = "ch.elexis.data.NutritionLeistung";
	
	private static IBillableOptifier<NutritionLeistung> optifier;
	private IBillableVerifier verifier;
	
	public NutritionLeistung(ch.elexis.core.jpa.entities.NutritionLeistung entity){
		super(entity);
		verifier = new DefaultVerifier();
	}
	
	@Override
	public synchronized IBillableOptifier<NutritionLeistung> getOptifier(){
		if (optifier == null) {
			optifier = new AbstractOptifier<NutritionLeistung>(CoreModelServiceHolder.get(), ContextServiceHolder.get()) {
				
				@Override
				protected void setPrice(NutritionLeistung billable, IBilled billed){
					billed.setFactor(1.0);
					int points = 0;
					if (billable.getTP() != null) {
						try {
							points = Integer.valueOf(billable.getTP());
						} catch (NumberFormatException ne) {
							// ignore ...
						}
					}
					billed.setPoints(points);
				}
			};
		}
		return optifier;
	}
	
	@Override
	public IBillableVerifier getVerifier(){
		return verifier;
	}
	
	@Override
	public String getCodeSystemCode(){
		return "510";
	}
	
	@Override
	public String getCodeSystemName(){
		return ch.elexis.core.jpa.entities.NutritionLeistung.CODESYSTEM_NAME;
	}
	
	@Override
	public String getCode(){
		return getEntity().getCode();
	}
	
	@Override
	public void setCode(String value){
		// TODO Auto-generated method stub
	}
	
	@Override
	public String getText(){
		return getEntity().getText();
	}
	
	@Override
	public void setText(String value){
		getEntityMarkDirty().setCodeText(value);
		
	}
	
	@Override
	public LocalDate getValidFrom(){
		return getEntity().getValidFrom();
	}
	
	@Override
	public void setValidFrom(LocalDate value){
		getEntityMarkDirty().setValidFrom(value);
	}
	
	@Override
	public LocalDate getValidTo(){
		return getEntity().getValidUntil();
	}
	
	@Override
	public void setValidTo(LocalDate value){
		getEntityMarkDirty().setValidUntil(value);
	}
	
	@Override
	public String getTP(){
		return getEntity().getTp();
	}
	
	@Override
	public void setTP(String value){
		getEntityMarkDirty().setTp(value);
	}
	
	@Override
	public String getDescription(){
		return getEntity().getDescription();
	}
	
	@Override
	public void setDescription(String value){
		getEntityMarkDirty().setDescription(value);
	}
	
	@Override
	public String getLabel(){
		return getCode() + " " + getText();
	}
	
	@Override
	public boolean addXid(String domain, String id, boolean updateIfExists){
		return XidServiceHolder.get().addXid(this, domain, id, updateIfExists);
	}
	
	@Override
	public IXid getXid(String domain){
		return XidServiceHolder.get().getXid(this, domain);
	}
}