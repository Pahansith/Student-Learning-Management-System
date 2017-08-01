/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.secure;

/**
 *
 * @author Pahansith
 */
public class SecureData {

    public static String encryptData(String originalText, int shift) {

        char[] originalTextCharArr = originalText.toCharArray();
        int firstCharIdx = 'A';
        int offset = ('z' - 'A') + 1;

        for (int i = 0; i < originalTextCharArr.length; i++) {

            char oldCharIdx = originalTextCharArr[i];
            int oldIdxInAlphabet = oldCharIdx - firstCharIdx;
            int newIdxInAlphabet = (oldIdxInAlphabet + shift) % offset;

            char newCharIdx = (char) (firstCharIdx + newIdxInAlphabet);
            originalTextCharArr[i] = newCharIdx;
        }

        return new String(originalTextCharArr);
    }

    public static String decryptData(String cipheredText, int shift) {
        return encryptData(cipheredText, shift * -1);
    }
}
