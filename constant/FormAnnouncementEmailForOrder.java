package devcldkai.kaipizzas.constant;

import devcldkai.kaipizzas.domain.entities.CartItem;
import devcldkai.kaipizzas.util.EmailUtil;

import java.util.Collections;
import java.util.List;

public class FormAnnouncementEmailForOrder {

    private FormAnnouncementEmailForOrder() {}

    public static FormAnnouncementEmailForOrder getForm(){
        return new FormAnnouncementEmailForOrder();
    }

    public String SendOrder(Long orderId, String contactName, List<CartItem> cartItems) {
        String link = "http://localhost:8080/trackingorder?orderId=" + orderId;

        String content =
                "<html>" +
                        "<head>" +
                        "    <style>" +
                        "        a.button {" +
                        "            display: inline-block;" +
                        "            padding: 10px 10px;" +
                        "            color: white;" +
                        "            background-color: #28a745;" +
                        "            text-decoration: none;" +
                        "            border-radius: 5px;" +
                        "            font-size: 16px;" +
                        "        }" +
                        "        a.button:hover {" +
                        "            background-color: #218838;" +
                        "        }" +
                        "    </style>" +
                        "</head>" +
                        "<body style=\"font-family: Arial, sans-serif; line-height: 1.6;\">" +
                        "    <h2 style=\"color: #333;\">Kaicourses - Order Invoice</h2>" +
                        "    <p>Hello, " + contactName + "</p>" +
                        "    <p>Thank you for ordering from <strong>Kaicourses</strong>. Below are the details of your invoice:</p>" +
                        "    <p><strong>Order ID:</strong> <span style=\"color: #28a745;\">" + orderId + "</span></p>" +
                        "    <p><strong>Items:</strong></p>" +
                        "    <ul style=\"list-style-type: disc; padding-left: 20px; color: #555;\">" +
                        createList(cartItems) +
                        "    </ul>" +
                        "    <p>You can track your order status by clicking the button below:</p>" +
                        "    <a href=\"" + link + "\" class='button'>Tracking now!</a>" +
                        "    <br/>" +
                        "    <p>Enjoy your meal and have a great day!</p>" +
                        "    <p style=\"font-weight: bold; color: #333;\">Kaicourses</p>" +
                        "    <p style=\"font-weight: bold; color: #333;\">created by devcldkai @2025</p>" +
                        "</body>" +
                        "</html>";

        return content;
    }


    public String createList(List<CartItem> cartItemList){
        StringBuilder stringBuilder = new StringBuilder();
        cartItemList.forEach(x->stringBuilder.append("<li>"+x.getProducts().getName()+"</li>").append("\n"));
        return stringBuilder.toString();
    }

    public static void main(String[] args){

        EmailUtil.sendEmail("cesblus@gmail.com", "Tracking your order", FormAnnouncementEmailForOrder.getForm().SendOrder(1003L, "Thanh Như", Collections.emptyList()));
    }

}
