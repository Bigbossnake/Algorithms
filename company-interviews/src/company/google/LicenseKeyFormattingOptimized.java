package company.google;

import java.util.Optional;

public class LicenseKeyFormattingOptimized {

    private static final String EMPTY_LICENSE  = "";
    private static final char DASH_SEPARATOR   = '-';

    public String licenseKeyFormatting(String license, int K) {

        int tokenCounter = 0;
        StringBuilder licenseKeyFormatted  = new StringBuilder();

        if (!Optional.ofNullable(license).isPresent() || license.isEmpty()) {
            return EMPTY_LICENSE;
        }

        for (int i = license.length() -1; i >= 0; i --) {
            char currentLicenseChar = license.charAt(i);

            if (currentLicenseChar != DASH_SEPARATOR) {
                licenseKeyFormatted.append(currentLicenseChar);
                tokenCounter++;
            }

            if (tokenCounter == K) {
                tokenCounter = 0;
                licenseKeyFormatted.append(DASH_SEPARATOR);
            }
        }

        if (licenseKeyFormatted.length() > 0 &&
                licenseKeyFormatted.charAt(licenseKeyFormatted.length() - 1) == DASH_SEPARATOR) {
            licenseKeyFormatted.deleteCharAt(licenseKeyFormatted.length() - 1);
        }

        return licenseKeyFormatted.reverse().toString().toUpperCase();
    }
}
