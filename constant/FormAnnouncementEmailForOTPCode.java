package devcldkai.kaipizzas.constant;

public class FormAnnouncementEmailForOTPCode {

    private FormAnnouncementEmailForOTPCode() {}

    public static FormAnnouncementEmailForOTPCode getInstance(){
        return new FormAnnouncementEmailForOTPCode();
    }

    public String getForm(String otpCode){
        String emailVerificationHTML = "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Email Verification</title>\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "    <script type=\"module\" src=\"https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js\"></script>\n" +
                "    <script nomodule src=\"https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js\"></script>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Nunito&display=swap\" rel=\"stylesheet\">\n" +
                "    <style>\n" +
                "      a {\n" +
                "        color: #365cce;\n" +
                "        text-decoration: none;\n" +
                "      }\n" +
                "      .border {\n" +
                "        border-style: solid;\n" +
                "        border-width: 1px;\n" +
                "        border-color: #365cce;\n" +
                "        border-radius: 0.25rem;\n" +
                "      }\n" +
                "      .otpbox {\n" +
                "        display: flex;\n" +
                "        align-items: center;\n" +
                "        justify-content: center;\n" +
                "        width: 2rem;\n" +
                "        height: 2rem;\n" +
                "        font-size: 12px;\n" +
                "        font-weight: bold;\n" +
                "        color: #365cce;\n" +
                "      }\n" +
                "      .emailicon {\n" +
                "        font-size: 2rem;\n" +
                "        margin-left: 16px;\n" +
                "      }\n" +
                "      .btnVerify {\n" +
                "        padding-left: 1.25rem;\n" +
                "        padding-right: 1.25rem;\n" +
                "        padding-top: 0.5rem;\n" +
                "        padding-bottom: 0.5rem;\n" +
                "        margin-top: 1.5rem;\n" +
                "        font-size: 14px;\n" +
                "        font-weight: bold;\n" +
                "        text-transform: capitalize;\n" +
                "        background-color: #f97316;\n" +
                "        color: #ffff;\n" +
                "        transition-property: background-color, transform;\n" +
                "        transition-duration: 300ms;\n" +
                "        transform: none;\n" +
                "        border-radius: 0.375rem;\n" +
                "        border-width: 1px;\n" +
                "        border: none;\n" +
                "        outline: none;\n" +
                "        cursor: pointer;\n" +
                "      }\n" +
                "      .btnVerify:hover {\n" +
                "        background-color: #f75b07;\n" +
                "        transform: scale(1.05);\n" +
                "      }\n" +
                "      @media (min-width: 640px) {\n" +
                "        .footertext {\n" +
                "          font-size: 16px;\n" +
                "        }\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div style=\"display: flex; align-items: center; justify-content: center; flex-direction: column; margin-top: 1.25rem; font-family: Nunito, sans-serif\">\n" +
                "      <section style=\"max-width: 42rem; background-color: #fff;\">\n" +
                "          <div style=\"display: flex; flex-direction: column; gap: 1.25rem;\">\n" +
                "            <div style=\"font-size: 24px; font-weight: bold; text-transform: capitalize; text-align: center\">\n" +
                "              Your OTP code to change E-mail Address\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        <main style=\"margin-top: 2rem; padding-left: 1.25rem; padding-right: 1.25rem;\">\n" +
                "          <h4 style=\"color: #374151;\">Hello</h4>\n" +
                "          <p style=\"line-height: 1.5; color: #4b5563;\">\n" +
                "            Please copy your OTP code and input through form change email\n" +
                "          </p>\n" +
                "          <p style=\"margin-top: 1rem; line-height: 1.75; color: #4b5563;\">\n" +
                "            This email will only be valid for the next\n" +
                "            <span style=\"font-weight: bold;\"> 5 minutes</span>. If verify failed, please create your account again:\n" +
                "          </p>\n" +
                "          <h1 style=\"color: red; font-style:bold\">\n" +
                "  "+otpCode+"\n" +
                "          </h1>\n" +
                "          <p style=\"margin-top: 2rem; color: #4b5563;\">\n" +
                "            Thank you, <br />\n" +
                "            The Kaicourses Team\n" +
                "          </p>\n" +
                "        </main>\n" +
                "        <p style=\"color: #7b8794; padding-left: 1.25rem; padding-right: 1.25rem; margin-top: 2rem;\">\n" +
                "          This email was sent from\n" +
                "          <a href=\"mailto:sales@infynno.com\" style=\"color: #365cce; text-decoration: none;\" alt=\"sales@infynno.com\" target=\"_blank\">\n" +
                "            kag40222@gmail.com\n" +
                "          </a>\n" +
                "          . If you&apos;d rather not receive this kind of email, you can\n" +
                "          <a href=\"#\" style=\"color: #365cce; text-decoration: none;\">unsubscribe</a>\n" +
                "          or\n" +
                "          <a href=\"#\" style=\"color: #365cce; text-decoration: none;\">manage your email preferences</a>.\n" +
                "        </p>\n" +
                "      </section>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>";
        return emailVerificationHTML;
    }
}
