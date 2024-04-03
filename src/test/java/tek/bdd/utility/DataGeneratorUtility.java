package tek.bdd.utility;

import java.util.Random;

public class DataGeneratorUtility {

// NOTE: We can develop this class as Static which we did, and we call the methods directly!
//       Or we can use Inheritance to extend the class to this class and this class to a parent class!
//       OR we can call an object of this class!
//   It all matters how your structure is and how do you want to develop your structure!

// Since we're using the signUp option, we cannot use the same email over and over again! Once we create an email, that email will be stored in the database and the application will not accept
// that value again! To resolve, we have to come up with a method to change the email mohammad4633@tekschool.us number randomly so the application can accept it! String manipulation

    // This method is design to create random number between the name and @ sign to allow us to generate emails with random numbers to avoid failure in our testing frameWork!
    // This Method returns a String value and has a parameter of String Email.
    public static String randomEmail(String email) {
//   We are creating a copy of Random class!
        Random random = new Random();
//  We are creating random numbers between 0 t0 1000 (999) different possibilities! And has to be stored in "int number"
        int number = random.nextInt(1000);
//  In this step, we need to append it with the use of String manipulation.    HOW DO WE MANIPULATE IT???    Email = mohammad@gmail.com
//  We need to this part of the text "@gmail.com" the part which is left is "mohammad" then you have to add the random(123) number then put back the part of the text which is: "@gmail.com".
        int indexOfAtSign = email.indexOf("@");
//  We are now manipulating by taking the use of substring from index 0 to @ sign and store it as firstPart!
        String firstPart = email.substring(0, indexOfAtSign);
//  Then we take index of @ sign to the end as stored it as secondPart!
        String secondPart = email.substring(indexOfAtSign);
//  And in the return, we are placing the random number between the two parts which will place the random number between the name and @gmail.com! example: mohammad786@gmail.com!
        return firstPart + number + secondPart;
    }

    /* Created this main method to test the method we have created!

    public static void main(String[] args) {

        System.out.println(randomEmail("Ferdaws@gmail.com"));
    }*/
}


