package cw2_q1;
import java.util.*;
public class CW2_Q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        //declaration
        double sumPrice=0, purchasedDiscount;
        int sumQty=0;
        char addItem;
        
        System.out.println("Welcome! Are you a member ? (Y/N): ");
        char memberStatus = s.next().toLowerCase().charAt(0);
        while (memberStatus!='y' && memberStatus!='n') {
            System.out.println("Invalid input! Please enter Y for Yes or N for No: ");
            memberStatus = s.next().toLowerCase().charAt(0);
        }
        //Prompt User to select the product
        do {
            System.out.printf("%-25s | %10s%n","Skincare Product", "Price(RM)");
            System.out.println("______________________________________");
            System.out.printf("%-25s | %10d%n", "1. Facial Foam", 45);
            System.out.printf("%-25s | %10d%n", "2. Toner", 35);
            System.out.printf("%-25s | %10d%n", "3. Moisturizing Cream", 65);
            System.out.printf("%-25s | %10d%n", "4. Eye Serum", 88);
            System.out.println("\nEnter item code(1-4): ");
            int itemCode = s.nextInt();
        
            //Validate if item code is between the range
            while (itemCode<1 || itemCode>4) {
               System.out.println("Invalid number! Enter the correct item code(1-4): ");
               itemCode = s.nextInt();
            }
            
            //Prompt user to enter the quantity for each
            System.out.println("Enter the quantity: ");
            int qty = s.nextInt();
            
            //Validate if quantity is >0
            while (qty<1) {
                System.out.println("Quantity must be more than 0! Enter the correct quantity: ");
                qty = s.nextInt();
            }
            // calculate the total number of item
            sumQty += qty;
            
            //calculate price for each item
            switch (itemCode) {
                case 1 -> sumPrice+= 45 * qty;
                case 2 -> sumPrice+= 35 * qty;
                case 3 -> sumPrice+= 65 * qty;
                case 4 -> sumPrice+= 88 * qty;
            }
            
            //ask if user want to add more item
            System.out.println("Do u want to add more item? (Y/N): ");
            addItem = s.next().toLowerCase().charAt(0);
            while (addItem!='y' && addItem!='n') {
            System.out.println("Invalid input! Please enter Y for Yes or N for No: ");
            memberStatus = s.next().toLowerCase().charAt(0);
            }
        }while (addItem == 'y'); //loop if user want to add more item
        
        //Subtotal before discount
        System.out.println("Thank you for your purchase!");
        System.out.printf("Subtotal price: RM %.2f%n" , sumPrice);
        
        //Apply discount
        //Calculate the discount base on the total number of item
        if (sumQty>5)
            purchasedDiscount=0.08;
        else if (sumQty>2)
            purchasedDiscount=0.05;
        else
            purchasedDiscount=0;
        
        
        //purchased discount
        double discountPrice = sumPrice*purchasedDiscount;
        sumPrice -= discountPrice;
        //check if user has membership 
        double memberDiscount = (memberStatus=='y')? 0.05:0;
        //membership discount
        double memberDiscountPrice = sumPrice * memberDiscount;
        sumPrice -= memberDiscountPrice;
        
        System.out.printf("Purchased Discount: - RM %.2f%n", discountPrice);
        System.out.printf("Membership Discount: - RM %.2f%n", memberDiscountPrice);
        System.out.printf("Total price: RM %.2f%n" , sumPrice);
    }
    
}
