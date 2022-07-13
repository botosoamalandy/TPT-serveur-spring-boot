package com.tptransversal.rdvvaksiny.autre;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Crypte {

	private SecretKeySpec secretKey;
	private byte[] key;

	public void setKey(String myKey) 
	{
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16); 
			secretKey = new SecretKeySpec(key, "AES");
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String strToEncrypt, String secret) 
	{
		try 
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} 
		catch (Exception e) 
		{
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public String decrypt(String strToDecrypt, String secret) 
	{
		try 
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} 
		catch (Exception e) 
		{
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
	public String deleteEspace(String valeur) {
		String []strings=valeur.split(" ");int size=strings.length;
		if(size>1) {
			String resultat="";
			for (int i = 0; i < size; i++) {
				resultat=resultat+strings[i];
			}
			return resultat;
		}
		return valeur;
	}
	public String cryptagePasswords(String nomUtilisateur,String passwords) {
		return encrypt(passwords,deleteEspace(nomUtilisateur));
	}
	public String decryptagePasswords(String nomUtilisateur,String passwordCrypted) {
		return decrypt(passwordCrypted,deleteEspace(nomUtilisateur));
	}
	
	public String newCryptage(String valeur) {
		byte[] bytes = valeur.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes){
            int val = b;
            for (int i = 0; i < 8; i++){
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append('2');
        }
        return binary.toString();
	}
	public String rectificationBinary(String binary) {
		String []strings=binary.split("2");int size = strings.length;
		String newString = "";
		for (int i = 0; i < size; i++) {
			if(!strings[i].equals("")) {
				newString=newString+strings[i]+" ";
			}
		}
		return newString;
	}
	public String decrypteIncomplet(String letters){ 
		 String s = "";
		 for(int index = 0; index < letters.length(); index+=9) {
		     String temp = letters.substring(index, index+8);
		     int num = Integer.parseInt(temp,2);
		     char letter = (char) num;
		     s = s+letter;
		 }
		 return s;
	}
	public String newDecryptage(String valeur) {
		return decrypteIncomplet(rectificationBinary(valeur));
	}
}
