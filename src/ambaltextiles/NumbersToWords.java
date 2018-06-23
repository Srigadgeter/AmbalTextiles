/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambaltextiles;

/**
 *
 * @author Sridhar
 */
public class NumbersToWords {

    public String conversion(String amount) {
        StringBuffer sb = new StringBuffer(amount);
        String rev = sb.reverse().toString();

        char[] c = rev.toCharArray();

        String rs, ones = "", tens = "", hunds = "", thous = "", tenThous = "",
                lakhs = "", tenLakhs = "", crores = "", tenCrores = "";

        if (Integer.parseInt(amount) == 0) {
            rs = "ZERO ONLY";
        } else {

            for (int i = 0; i < amount.length(); i++) {
                if (i == 8) {
                    if (c[i] == '1') {
                        tenCrores = teens(c[i - 1]);
                        crores = " CRORES";
                    } else {
                        tenCrores = num(c[i]);
                    }

                    if (c[i - 1] == '0' && c[i] > '1') {
                        crores = " CRORES";
                    }
                }
                if (i == 7) {
                    crores = numbers(c[i]);
                    if (c[i] == '1') {
                        crores += " CRORE";
                    }
                    if (c[i] >= '2' && c[i] <= '9') {
                        crores += " CRORES";
                    }
                }
                if (i == 6) {
                    if (c[i] == '1') {
                        tenLakhs = teens(c[i - 1]);
                        lakhs = " LAKHS";
                    } else {
                        tenLakhs = num(c[i]);
                    }

                    if (c[i - 1] == '0' && c[i] > '1') {
                        lakhs = " LAKHS";
                    }
                }
                if (i == 5) {
                    lakhs = numbers(c[i]);
                    if (c[i] == '1') {
                        lakhs += " LAKH";
                    }
                    if (c[i] >= '2' && c[i] <= '9') {
                        lakhs += " LAKHS";
                    }
                }
                if (i == 4) {
                    if (c[i] == '1') {
                        tenThous = teens(c[i - 1]);
                        thous = " THOUSANDS";
                    } else {
                        tenThous = num(c[i]);
                    }

                    if (c[i - 1] == '0' && c[i] > '1') {
                        thous = " THOUSANDS";
                    }
                }
                if (i == 3) {
                    thous = numbers(c[i]);
                    if (c[i] == '1') {
                        thous += " THOUSAND";
                    }
                    if (c[i] >= '2' && c[i] <= '9') {
                        thous += " THOUSANDS";
                    }
                }
                if (i == 2) {
                    hunds = numbers(c[i]);
                    if (c[i] == '1') {
                        hunds += " HUNDRED";
                    }
                    if (c[i] >= '2' && c[i] <= '9') {
                        hunds += " HUNDREDS";
                    }
                }
                if (i == 1) {
                    if (c[i] == '1') {
                        tens = teens(c[i - 1]);
                        ones = " ONLY";
                    } else {
                        tens = num(c[i]);
                    }
                }
                if (i == 0) {
                    ones = numbers(c[i]) + " ONLY";
                }
            }

            rs = tenCrores + crores + " " + tenLakhs + lakhs + " " + tenThous + thous + " " + hunds + " " + tens + ones;
            rs = rs.trim();
            rs = rs.replaceAll("\\s+", " ");
        }
        return rs;
    }

    private String numbers(char cc) {
        if (cc == '9') {
            return "NINE";
        }
        if (cc == '8') {
            return "EIGHT";
        }
        if (cc == '7') {
            return "SEVEN";
        }
        if (cc == '6') {
            return "SIX";
        }
        if (cc == '5') {
            return "FIVE";
        }
        if (cc == '4') {
            return "FOUR";
        }
        if (cc == '3') {
            return "THREE";
        }
        if (cc == '2') {
            return "TWO";
        }
        if (cc == '1') {
            return "ONE";
        }
        return "";
    }

    private String num(char cc) {
        if (cc == '9') {
            return "NINTY";
        }
        if (cc == '8') {
            return "EIGHTY";
        }
        if (cc == '7') {
            return "SEVENTY";
        }
        if (cc == '6') {
            return "SIXTY";
        }
        if (cc == '5') {
            return "FIFTY";
        }
        if (cc == '4') {
            return "FORTY";
        }
        if (cc == '3') {
            return "THIRTY";
        }
        if (cc == '2') {
            return "TWENTY";
        }
        return "";
    }

    private String teens(char cc) {
        if (cc == '9') {
            return "NINETEEN";
        }
        if (cc == '8') {
            return "EIGHTEEN";
        }
        if (cc == '7') {
            return "SEVENTEEN";
        }
        if (cc == '6') {
            return "SIXTEEN";
        }
        if (cc == '5') {
            return "FIFTEEN";
        }
        if (cc == '4') {
            return "FOURTEEN";
        }
        if (cc == '3') {
            return "THIRTEEN";
        }
        if (cc == '2') {
            return "TWELVE";
        }
        if (cc == '1') {
            return "ELEVEN";
        }
        if (cc == '0') {
            return "TEN";
        }
        return "";
    }

}
