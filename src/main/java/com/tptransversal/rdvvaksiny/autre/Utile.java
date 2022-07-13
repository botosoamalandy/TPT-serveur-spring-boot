package com.tptransversal.rdvvaksiny.autre;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.tptransversal.rdvvaksiny.model.DecodeToken;
import com.tptransversal.rdvvaksiny.model.Utilisateur;
import com.tptransversal.rdvvaksiny.model.Vaccinodrome;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@SuppressWarnings("deprecation")
public class Utile {
	public String getSexe(int codeSexe) {
		if(codeSexe>1) {
			return "Femme";
		}
		return "Homme";
	}
	public String generateJwtByUser(Utilisateur utilisateur,int codeTypeUtilisateur,String key) {
		Date issuedAt = getDateNow(),expiration = issuedAt;
		expiration.setDate(expiration.getDate()+1);
		
		Claims claims = Jwts.claims()
				.setIssuer(""+utilisateur.getIdutilisateur())
				.setIssuedAt(issuedAt)
				.setExpiration(expiration);
		claims.put("codeutilisateur",codeTypeUtilisateur);
		claims.put("nom",""+utilisateur.getNom());
		claims.put("email",""+utilisateur.getEmail());
		claims.put("expiration",expiration.getTime());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, key).compact();
	}
	public String generateJwtByVaccinodrome(Vaccinodrome vaccinodrome,int codeAuth,String key) {
		Date issuedAt = getDateNow(),expiration = issuedAt;
		expiration.setDate(expiration.getDate()+1);
		Claims claims = Jwts.claims()
				.setIssuer(""+vaccinodrome.getIdVaccinodrome())
				.setIssuedAt(issuedAt)
				.setExpiration(expiration);
		claims.put("codeutilisateur",codeAuth);
		claims.put("nom",""+vaccinodrome.getNomCentre());
		claims.put("email",""+vaccinodrome.getEmail());
		claims.put("expiration",expiration.getTime());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, key).compact();
	}
	public DecodeToken decodeGeneratedJwtByUser(String token) throws Exception {
		String payload = token.split("\\.")[1];
		String jsonString = new String(Base64.decodeBase64(payload),"UTF-8");
		return new Gson().fromJson(jsonString, DecodeToken.class);
	}
	public boolean verifString(String valeur) {
		if(!valeur.equals("") && valeur!=null && valeur!=" ") {
			return true;
		}
		return false;
	}
	
	public Long setStringToLong(String valeur) {
		try {
			return Long.parseLong(valeur);
		} catch (Exception e) {
			return 0L;
		}
	}
	
	public int setStringToInt(String valeur) {
		try {
			return Integer.parseInt(valeur);
		} catch (Exception e) {
			return 0;
		}
	}
	public double setStringToDouble(String valeur) {
		try {
			return Double.parseDouble(valeur);
		} catch (Exception e) {
			return 0;
		}
	}
	public boolean setStringToBoolean(String valeur) {
		if(valeur.equals("true")) {
			return true;
		}else {
			return false;
		}
	}
	public String completInteger(int valeur) {
		if(Math.abs(valeur) >=0 && Math.abs(valeur)<=9) {
			return "0"+valeur;
		}else {
			return ""+valeur;
		}
	}
	public double setZeroIfNegatif(double valeur) {
		if(valeur<=0) {
			return 0;
		}
		return valeur;
	}
	public int createCodeDeValidation() {
		int codeValidation= ((int)(Math.random()*10000));
		if(codeValidation<=1000) {
			return codeValidation+(1000*2);
		}else if(codeValidation>9999) {
			return codeValidation-(1000*2); 
		}else {
			return codeValidation;
		}
	}
	public Calendar createCalendar(int jour, int mois , int annee) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,jour);
		calendar.set(Calendar.MONTH,mois);
		calendar.set(Calendar.YEAR,annee);
		return calendar;
	}
	public Calendar setDateToCalender(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	public int nombreDeJourDansUnMois(int mois,int annee) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mois);cal.set(Calendar.YEAR, annee);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public Date createDate(int jour,int mois,int annee) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, jour);cal.set(Calendar.MONTH, mois);cal.set(Calendar.YEAR, annee);
		return new Date(cal.getTimeInMillis());
	}
	
	public java.sql.Date getDateNow() {
		Calendar calendar = Calendar.getInstance();
		return new java.sql.Date(calendar.getTimeInMillis());
	}
	public Calendar convertStringToCalenderOne(String calendarString) {
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dateObj = curFormater.parse(calendarString); 
			calendar .setTime(dateObj);
			return calendar;
		} catch (Exception e) {
			return calendar;
		}
	}
	public java.sql.Date convertStringToCalender(String calendarString) {
		return new java.sql.Date(convertStringToCalenderOne(calendarString).getTimeInMillis());
	}
	public Time convertStringToTime(String timeString) {
		Calendar calendar = Calendar.getInstance();
		try {
			DateFormat formatter = new SimpleDateFormat("hh:mm");
			Date date = (Date)formatter.parse(timeString);
			return new java.sql.Time(date.getTime());
		} catch (Exception e) {
			return new java.sql.Time(calendar.getTimeInMillis());
		}
	}
	public Time convertStringToTimeTwo(String timeString) {
		Calendar calendar = Calendar.getInstance();
		try {
			DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
			Date date = (Date)formatter.parse(timeString);
			return new java.sql.Time(date.getTime());
		} catch (Exception e) {
			return new java.sql.Time(calendar.getTimeInMillis());
		}
	}
	
	public Timestamp createTimestamp() {
		Calendar calendar=Calendar.getInstance();
		return new Timestamp(calendar.get(Calendar.YEAR)-1900,calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND),calendar.get(Calendar.SECOND));
	}
	public Calendar setTimestampToCalender(Timestamp timestamp) {
		Calendar calendar=createCalendar(timestamp.getDate(),timestamp.getMonth(),timestamp.getYear()+1900);
		calendar.set(Calendar.HOUR_OF_DAY,timestamp.getHours());
		calendar.set(Calendar.MINUTE,timestamp.getMinutes());
		return calendar;
	}
	public String countPage(int count,int max) { 
		Json json=new Json();
		try {
			float counts = ((float)count)/((float)max);int page = 0;
			if(counts>0) {
				double tmp = ((int)counts)+0.09;
				if(counts>tmp) {
					page = ((int)counts)+1;
				}else {
					page = ((int)counts);
				}
			}
			json.put("pageTotal",page);
			return json.toString();
		} catch (Exception e) {
			json.put("pageTotal",0);
			return json.toString();
		}
	}
	public int countPageV2(int countTotal,int limit) { 
		try {
			float counts = ((float)countTotal)/((float)limit);int page = 0;
			if(counts>0) {
				double tmp = ((int)counts)+0.09;
				if(counts>tmp) {
					page = ((int)counts)+1;
				}else {
					page = ((int)counts);
				}
			}
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int setPageToOffset(int limit,int page) {
		if(page > 1 ) {
			return (page - 1) * limit;
		}
		return 0;
	}
	public String supprimerLesEspace(String libeller) {
		return libeller.replaceAll("\\s","");
	}
}
