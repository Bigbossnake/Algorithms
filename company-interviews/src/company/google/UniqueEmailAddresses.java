package company.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {

        Map<String, Boolean> emailsForwarded = new HashMap<>();

        if (!Optional.ofNullable(emails).isPresent()) {
            return 0;
        }

        Arrays.stream(emails).forEach(email -> {

           String[] emailData  =  email.split("@");
           String emailAddress = emailData[0];
           String emailDomain  = emailData[1];

           StringBuilder forwardedEmail = new StringBuilder();

           for (int i = 0; i < emailAddress.length(); i++) {
               char currentChar = emailAddress.charAt(i);

               if (currentChar == '.') {
                   continue;
               }

               if (currentChar == '+') {
                   break;
               }

               forwardedEmail.append(currentChar);
           }

           forwardedEmail.append("@");
           forwardedEmail.append(emailDomain);

           if (!emailsForwarded.containsKey(forwardedEmail.toString())) {
               emailsForwarded.put(forwardedEmail.toString(), true);
           }

        });

        return emailsForwarded.size();
    }
    
}
