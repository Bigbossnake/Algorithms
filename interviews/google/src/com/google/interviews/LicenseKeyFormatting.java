package com.google.interviews;

import java.util.Optional;

public class LicenseKeyFormatting {

    private static final String EMPTY_LICENSE  = "";
    private static final char DASH_SEPARATOR   = '-';

    public String licenseKeyFormatting(String license, int K) {

        int tokenCounter     = 0;
        int firstTokenLength = 0;
        int licenseFormattedPossibleLength = 0;
        String licenseKeyPreFormatted      = "";
        StringBuilder licenseKeyFormatted  = new StringBuilder();
        StringBuilder licenseKeyChars      = new StringBuilder();

        if (!Optional.ofNullable(license).isPresent() || license.isEmpty()) {
            return EMPTY_LICENSE;
        }

        for (int i = 0; i < license.length(); i++) {
            Character currentLicenseChar = license.charAt(i);

            if (currentLicenseChar != DASH_SEPARATOR) {
                licenseFormattedPossibleLength++;
                licenseKeyChars.append(currentLicenseChar);
            }
        }

        if (licenseFormattedPossibleLength % K == 0) {
            firstTokenLength = -1;
        } else {
            firstTokenLength = licenseFormattedPossibleLength % K;
        }

        licenseKeyPreFormatted = licenseKeyChars.toString().toUpperCase();

        for (int i = 0; i < licenseKeyPreFormatted.length(); i++) {
            Character currentLicenseChar = licenseKeyPreFormatted.charAt(i);
            licenseKeyFormatted.append(currentLicenseChar);
            tokenCounter ++;

            if (tokenCounter == K || tokenCounter == firstTokenLength) {
                tokenCounter = 0;
                firstTokenLength = -1;

                if (i + 1 < licenseKeyPreFormatted.length()) {
                    licenseKeyFormatted.append(DASH_SEPARATOR);
                }
            }
        }

        return licenseKeyFormatted.toString();
    }
}
