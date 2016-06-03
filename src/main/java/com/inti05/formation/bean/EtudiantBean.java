package com.inti05.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.inti05.formation.entities.Etudiant;
import com.inti05.formation.metier.InterEtudiantMetier;

@Controller
@Component("etudBean")
@RequestScoped
public class EtudiantBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private InterEtudiantMetier metierEtudiant;
	
	private Etudiant e =new Etudiant();
	private List<Etudiant> listeetu = new ArrayList<Etudiant>();
	private Long id;
	private String s;
	private Long idEx;
	private Long idM;
	private boolean skip;
	private String nomEtu;
	private String prenomEtu;
	private Date datedeNaissanceEtu;
	private String telephoneEtu;
	private String mail;
	private String specialitéEtu;
	private Etudiant getEtud ;
	

	

	public String getNomEtu() {
		return nomEtu;
	}
	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}
	public String getPrenomEtu() {
		return prenomEtu;
	}
	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}
	public Date getDatedeNaissanceEtu() {
		return datedeNaissanceEtu;
	}
	public void setDatedeNaissanceEtu(Date datedeNaissanceEtu) {
		this.datedeNaissanceEtu = datedeNaissanceEtu;
	}
	public String getTelephoneEtu() {
		return telephoneEtu;
	}
	public void setTelephoneEtu(String telephoneEtu) {
		this.telephoneEtu = telephoneEtu;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSpecialitéEtu() {
		return specialitéEtu;
	}
	public void setSpecialitéEtu(String specialitéEtu) {
		this.specialitéEtu = specialitéEtu;
	}



	
	public Etudiant getGetEtud() {
		return getEtud;
	}
	public void setGetEtud(Etudiant getEtud) {
		this.getEtud = getEtud;
	}
	public Etudiant getE() {
		return e;
	}
	
	
	public void setE(Etudiant e) {
		this.e = e;
	}
	public List<Etudiant> getListeetu() {
		return listeetu;
	}
	public void setListeetu(List<Etudiant> listeetu) {
		this.listeetu = listeetu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public Long getIdEx() {
		return idEx;
	}
	public void setIdEx(Long idEx) {
		this.idEx = idEx;
	}
	public Long getIdM() {
		return idM;
	}
	public void setIdM(Long idM) {
		this.idM = idM;
	}
	
	public EtudiantBean() {
		super();
		
	}
	
	   public boolean getSkip() {
	        return skip;
	    }
	 
	    public void setSkip(boolean skip) {
	        this.skip = skip;
	    }
	     
	  
	
	/************************Méthodes***********************************/
	
	
	public Etudiant addEtudiant(){
		metierEtudiant.addEtudiant(e);
		return e;
	
	}
	public List<Etudiant> listeEtudiant(){
		listeetu = metierEtudiant.listeEtudiant();
		return listeetu;
	}
	
	public Etudiant supEtudiant(){
		return metierEtudiant.supEtudiant(id);
	}
	public Etudiant modifEtudiant(){
		e= metierEtudiant.getById(id);
		if (nomEtu.length()>0){
			e.setNomEtu(nomEtu);
		}
		if(prenomEtu.length()>0){
			e.setPrenomEtu(prenomEtu);
		}
		if(datedeNaissanceEtu.getTime()>0){
			e.setDatedeNaissanceEtu(datedeNaissanceEtu);
		}
		if(mail.length()>0){
			e.setMail(mail);
		}
		if(telephoneEtu.length()>0){
			e.setTelephoneEtu(telephoneEtu);
		}
		if(specialitéEtu.length()>0){
			e.setSpecialitéEtu(specialitéEtu);
		}
		
		
		return metierEtudiant.modifEtudiant(e);
	}
	public List<Etudiant> getlistParMc(){
		return metierEtudiant.getlistParMc(s);
	}
	public  Etudiant getListNomExacte(String nom,String prenom){
	return metierEtudiant.getListNomExacte(nomEtu, prenomEtu);
		
	}
	public Etudiant getById(){
		getEtud = metierEtudiant.getById(id);
		return getEtud;

	}
	public Etudiant addExamToEtudiant(){
		return metierEtudiant.addExamToEtudiant(idEx, id);
	}
	public Etudiant supExamToEtudiant (){
		return metierEtudiant.supExamToEtudiant(idEx, id);
	}
	public Etudiant addMaterToEtudiant(){
		return metierEtudiant.addMaterToEtudiant(idM, id);
	}
	public Etudiant supMaterToEtudiant(){
		return metierEtudiant.supMaterToEtudiant(idM, id);
	}
	  public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }
}
